package com.sample.test.config;

public class URLGetter {

    public String getURLs(String portalName) {
        PropertyReader propertyReader = new PropertyReader();
        String url = propertyReader.readEnvSpecProperty(portalName);
       return url;
    }

    public static void main(String Args[]) {
        URLGetter a = new URLGetter();
    }
}
