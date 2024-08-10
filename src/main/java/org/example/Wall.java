package org.example;

import java.util.ArrayList;
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
        List<Block> result = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getMaterial().equalsIgnoreCase(material)) {
                result.add(block);
            }
            if (block instanceof CompositeBlock compositeBlock) {
                result.addAll(findBlocksByMaterialNested(compositeBlock.getBlocks(), material));
            }
        }
        return result;
    }

    private List<Block> findBlocksByMaterialNested(List<Block> blocks, String material) {
        List<Block> result = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getMaterial().equalsIgnoreCase(material)) {
                result.add(block);
            }
            if (block instanceof CompositeBlock compositeBlock) {
                result.addAll(findBlocksByMaterialNested(compositeBlock.getBlocks(), material));
            }
        }
        return result;
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