package com.wso2telco.is;

import org.apache.axis2.AxisFault;
import org.wso2.carbon.authenticator.stub.LoginAuthenticationExceptionException;

import java.rmi.RemoteException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        try {
            System.setProperty("javax.net.ssl.trustStore", "/home/chinthaka/Desktop/wso2is-5.2.0/repository/resources/security/wso2carbon.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "wso2carbon");
            System.setProperty("javax.net.ssl.trustStoreType", "JKS");

            LoginAdminServiceClient adminService = new LoginAdminServiceClient("https://localhost:9443");
            String authenticate = adminService.authenticate("admin", "admin");
            System.out.println(authenticate);

        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }  catch (RemoteException e) {
            e.printStackTrace();
        } catch (LoginAuthenticationExceptionException e) {
            e.printStackTrace();
        }
    }
}
