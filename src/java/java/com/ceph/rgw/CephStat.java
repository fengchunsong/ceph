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

/**
 * Holds struct stat fields.
 */
public class CephStat {
    private static final int FLAG_IFLNK = 0120000;
    private static final int FLAG_IFREG = 0100000;
    private static final int FLAG_IFDIR = 0040000;

    /* Set from native */
    public int mode;
    public int uid;
    public int gid;
    public long size;
    public long blksize;
    public long blocks;
    public long a_time;
    public long m_time;

    public CephStat() {
    }

    public CephStat(int mode) {
        this.mode = mode;
    }

    public CephStat(long m_time, long a_time) {
        this.m_time = m_time;
        this.a_time = a_time;
    }

    public CephStat(int mode, int uid, int gid, long size, long blksize, long blocks, long m_time, long a_time) {
        this.mode = mode;
        this.uid = uid;
        this.gid = gid;
        this.size = size;
        this.blksize = blksize;
        this.blocks = blocks;
        this.a_time = a_time;
        this.m_time = m_time;
    }

    public boolean isFile() {
        return (mode & FLAG_IFREG) != 0;
    }

    public boolean isDir() {
        return (mode & FLAG_IFDIR) != 0;
    }

    public boolean isSymlink() {
        return (mode & FLAG_IFLNK) != 0;
    }
}
