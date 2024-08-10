package org.example;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall() {
    }

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return List.of();
    }

    @Override
    public int count() {
        var count = 0;
        for (Block block : blocks) {
            count += countBlocks(block);
        }
        return count;
    }

    private int countBlocks(Block block) {
        var count = 0;
        if (block instanceof CompositeBlock compositeBlock) {
            for (Block b : compositeBlock.getBlocks()) {
                count += countBlocks(b);
            }
        }
        count++;
        return count;
    }
}