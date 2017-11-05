package com.danieljyc.service;

import com.danieljyc.domain.BlockModel;
import com.danieljyc.domain.BlockchainModel;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by DanielJyc on 2017-11-05 21:32.
 */
public interface BlockchainService {
    /**
     * 产生区块
     * 比特币中区块是通过“挖矿”得到的，不断的计算满足某个条件的hash值，这里通过简单的计算模拟：
     * sha256(index+hash+data+timestamp)
     *
     * @param blockData 区块的数据
     * @return 区块
     */
    BlockModel generateNextBlock(String blockData);

    /**
     * 往区块链中添加区块
     *
     * @param blockModel 被添加的区块
     * @return 添加结果
     */
    Boolean addBlockToBlockchain(BlockModel blockModel);

    /**
     * 验证区块的完整性:
     * 实际上就是看数据是否一致，是否被篡改。计算hash进行比对。
     *
     * @param newBlock      新的当前区块
     * @param previousBlock 上一个区块
     * @return 校验结果
     */
    Boolean isValidNewBlock(BlockModel newBlock, BlockModel previousBlock);

    /**
     * 校验区块链是否有效：校验创世区块和每个区块
     *
     * @param blockchainModel 区块链
     * @return 结果
     */
    Boolean isValidChain(BlockchainModel blockchainModel);


    /**
     * 区块链合并:
     * 在网络中，同时会有多个矿工在挖矿，如果大家几乎同时提交，那么比特币就会出现“分叉”，那么怎么办呢？
     * 解决：做法很简单，就是选择最长的链。
     *
     * @param receivedBlockchainModel 被合并的区块链
     * @return 合并结果
     */
    Boolean compareAndMergeBlockchain(BlockchainModel receivedBlockchainModel);

}
