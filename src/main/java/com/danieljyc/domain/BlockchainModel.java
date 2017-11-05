package com.danieljyc.domain;

import com.danieljyc.websocket.server.BlockchainWebSocket;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by DanielJyc on 2017-11-05 21:15.
 */
public class BlockchainModel extends BaseToString {
    /**
     * concurrent包的线程安全Set，用来存放区块链。
     */
    private static CopyOnWriteArraySet<BlockModel> blockModels = new CopyOnWriteArraySet<BlockModel>();

    public BlockchainModel() {
        BlockModel blockModel = getGenesisBlock();
        blockModels.add(blockModel);
    }

    /**
     * 创世区块，即第0个区块
     */
    private BlockModel getGenesisBlock() {
        return new BlockModel(0L, 12332L, "genesis block", "816534932c2b7154836da6afc367695e6337db8a921823784c14378abed4f7d7", "0");
    }

}
