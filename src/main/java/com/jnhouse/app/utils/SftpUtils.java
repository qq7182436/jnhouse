package com.jnhouse.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.commons.lang.SystemUtils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SftpUtils {

	protected String host;
    protected int port;
    protected String username;
    protected String password;

    /**
     * @param host ip
     * @param port 端口
     * @param username 账号
     * @param password 密码
     * */
    public SftpUtils(String host, int port, String username, String password) {
        set(host, port, username, password);
    }

    public void set(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    Session sshSession = null; 
    /**
     * 链接linux
     * */
    public ChannelSftp connect() {
        ChannelSftp sftp = null ;
        try {
            JSch jsch = new JSch();
            jsch.getSession(username, host, port);
            sshSession = jsch.getSession(username, host, port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
           // LogManager.info(String.format("%s connect success" , host));
            Channel channel = sshSession.openChannel("sftp");
            channel.connect() ; 
            sftp = (ChannelSftp) channel;
        } catch (Exception e) {
            //LogManager.err("connect:" + host , e ); 
            close( null );
            return null ; 
        }
        return sftp;
    }
    /**
     * linux上传文件
     * cd(directory) 是说将matlab当前搜索路径设置为由字符串变量directory指定的路径
     * */
    public void upload(String directory,File file){
        ChannelSftp sftp = connect() ; 
        try {
            if(null != sftp){
                sftp.cd(directory);
                sftp.put(new FileInputStream(file), file.getName());
            }
        } catch (Exception e) {
           // LogManager.err("upload:" + host , e ); 
        }finally{
            sftp.disconnect() ;
            sftp.exit();
            sshSession.disconnect();
        }
    }

    /**
     * linux下载文件
     * */
    public void get(String directory, String downloadFile) {
        ChannelSftp sftp = connect() ; 
        try {
            if(null != sftp){
                File file = new File( directory ) ; 
                String parent = getParent( file );
                sftp.cd( parent );
                File desc = new File(downloadFile);
                FileOutputStream outputStream = new FileOutputStream(desc);
                sftp.get(file.getName() , outputStream); 
               // LogManager.info(String.format("down %s suc" , directory));
                outputStream.close() ;
            }
        } catch (Exception e) {
           // LogManager.err("down error :" + directory , e ); 
        }finally{
            close(sftp);
        }
    }

    protected void close(ChannelSftp sftp){
        if(sftp!=null){
            sftp.disconnect() ;
            sftp.exit();
        }
        if(sshSession!=null){
            sshSession.disconnect();
        }
    }

    protected String getParent(File desc){
     /*   if(SystemUtils.getSystemType() == SystemType.WINDOWS){
            String parent = desc.getParent(); 
            return parent.replace("\\", "/"); 
        }*/
        return desc.getParent() ;
    }

    public static void main(String[] args) {

    	System.out.println("---------------");
        /**
         * @param host ip
         * @param port 端口
         * @param username 账号
         * @param password 密码
         * */
        SftpUtils sftpUtils = new SftpUtils("192.168.7.136" , 22 , "root" , "root") ; 
        sftpUtils.upload("/store_img", new File("/usr/java/img"));

       /// sftpUtils.get("/opt/datas/uploads/config.ini" , "E://123");
    }
}
