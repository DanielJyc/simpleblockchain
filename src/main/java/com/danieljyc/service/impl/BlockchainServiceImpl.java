package com.danieljyc.service.impl;

import com.danieljyc.domain.BlockModel;
import com.danieljyc.domain.BlockchainModel;
import com.danieljyc.service.BlockchainService;

/**
 * Created by DanielJyc on 2017-11-05 21:32.
 */
public class BlockchainServiceImpl implements BlockchainService {
    @Override
    public BlockModel generateNextBlock(String blockData) {
        return null;
    }

    @Override
    public Boolean addBlockToBlockchain(BlockModel blockModel) {
        return null;
    }

    @Override
    public Boolean isValidNewBlock(BlockModel newBlock, BlockModel previousBlock) {
        return null;
    }

    @Override
    public Boolean isValidChain(BlockchainModel blockchainModel) {
        return null;
    }

    @Override
    public Boolean compareAndMergeBlockchain(BlockchainModel receivedBlockchainModel) {
        return null;
    }
}
