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

import java.io.IOException;

/**
 * Ceph file/directory already exists.
 */
public class CephFileAlreadyExistsException extends IOException {

    private static final long serialVersionUID = 1L;

    /**
     * Construct CephFileAlreadyExistsException.
     */
    public CephFileAlreadyExistsException() {
        super();
    }

    /**
     * Construct CephFileAlreadyExistsException with message.
     */
    public CephFileAlreadyExistsException(String s) {
        super(s);
    }
}
