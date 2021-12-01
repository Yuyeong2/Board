package com.koreait.board2.model;

public class BoardParamVO {
    private int recordCnt;
    private int page;
    private int sIdx;

    public int getsIdx() {
        return sIdx;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
        this.sIdx = (page - 1) * recordCnt;
    }

    public int getRecordCnt() {
        return recordCnt;
    }

    public void setRecordCnt(int recordCnt) {
        this.recordCnt = recordCnt;
    }
}
