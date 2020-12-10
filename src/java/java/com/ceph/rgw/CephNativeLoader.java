// -*- mode:C++; tab-width:8; c-basic-offset:2; indent-tabs-mode:t -*-
// vim: ts=8 sw=2 smarttab ft=cpp

/*
 * Ceph - scalable distributed file system
 *
 * Copyright (C) 2020 Huawei Technologies Co., Ltd.
 *
 * This is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1, as published by the Free Software
 * Foundation. See file COPYING.
 *
 */
package com.ceph.rgw;

class CephNativeLoader {
    private static final CephNativeLoader instance = new CephNativeLoader();
    private static boolean initialized = false;

    private static final String JNI_PATH_ENV_VAR = "CEPH_JNI_PATH";
    private static final String LIBRARY_NAME = "cephrgw_jni";
    private static final String LIBRARY_FILE = "libcephrgw_jni.so";

    private CephNativeLoader() {
    }

    public static CephNativeLoader getInstance() {
        return instance;
    }

    public synchronized void loadLibrary() {
        if (initialized)
            return;

        boolean success = false;

        /*
         * Allow a Ceph specific environment variable to force
         * the loading path.
         */
        String path = System.getenv(JNI_PATH_ENV_VAR);
        try {
            if (path != null) {
                System.out.println("Loading libcephrgw-jni: " + path);
                System.load(path);
                success = true;
            } else {
                try {
                    /*
                     * Try default Java loading path(s)
                     */
                    System.out.println("Loading libcephrgw-jni from default path: " +
                            System.getProperty("java.library.path"));
                    System.loadLibrary(LIBRARY_NAME);
                    success = true;
                } catch (final UnsatisfiedLinkError ule1) {
                    try {
                        /*
                         * Try RHEL/CentOS default path
                         */
                        path = "/usr/lib64/" + LIBRARY_FILE;
                        System.out.println("Loading libcephrgw-jni: " + path);
                        System.load(path);
                        success = true;
                    } catch (final UnsatisfiedLinkError ule2) {
                        /*
                         * Try Ubuntu default path
                         */
                        path = "/usr/lib/jni/" + LIBRARY_FILE;
                        System.out.println("Loading libcephrgw-jni: " + path);
                        System.load(path);
                        success = true;
                    }
                }
            }
        } finally {
            System.out.println("Loading libcephrgw-jni: " +
                    (success ? "Success!" : "Failure!"));
        }

        /*
         * Finish initialization
         */
        CephRgwAdapter.native_initialize();
        initialized = true;
    }

}
