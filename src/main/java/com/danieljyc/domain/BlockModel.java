package com.danieljyc.domain;

import lombok.Data;

/**
 * Created by DanielJyc on 2017-11-05 19:58.
 */
@Data
public class BlockModel {

    public BlockModel(Long index, Long timestamp, String data, String hash, String preHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.hash = hash;
        this.preHash = preHash;
    }

    /**
     * 区块序号
     */
    private Long index;

    /**
     * 时间戳
     */
    private Long timestamp;

    /**
     * 数据
     */
    private String data;

    /**
     * 当前区块的哈希值
     */
    private String hash;

    /**
     * 上一个区块的哈希值
     */
    private String preHash;
}
