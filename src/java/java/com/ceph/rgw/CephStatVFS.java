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
 * Holds struct statvfs fields.
 */
public class CephStatVFS {
    public long bsize;
    public long frsize;
    public long blocks;
    public long bavail;
    public long files;
    public long fsid;
    public long namemax;
}
