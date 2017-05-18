package com.sicdlib.util.HBaseUtil;

import org.apache.hadoop.hbase.util.Bytes;

/**
 * Created by DeMH on 2017/4/27.
 */
public class HBPage {
    private int pageSize = 200;
    private int prePage = 1;
    private int nextPage = 1;
    private int pageCount = 0;
    private byte [] pageStartRowKey = null;
    private byte [] pageStopRowKey = null;

    public int getPageSize() {
        return pageSize;
    }

    public int getPrePage() {
        return prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public byte[] getPageStartRowKey() {
        return pageStartRowKey;
    }

    public byte[] getPageStopRowKey() {
        return pageStopRowKey;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setPageStartRowKey(byte[] pageStartRowKey) {
        this.pageStartRowKey = pageStartRowKey;
    }

    public void setPageStopRowKey(byte[] pageStopRowKey) {
        this.pageStopRowKey = pageStopRowKey;
    }
}
