/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author Omar
 */
public class HelperIP {
    public static String ipHelper;

    public static void setIpHelper(String ipHelper) {
        HelperIP.ipHelper = ipHelper;
    }
    static {
        ipHelper="127.0.0.1";
    }
}
