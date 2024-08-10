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
        return findBlockByColorNested(blocks, color);
    }

    private Optional<Block> findBlockByColorNested(List<Block> blocks, String color) {
        for (Block block : blocks) {
            if (block.getColor().equalsIgnoreCase(color)) {
                return Optional.of(block);
            }

            if (block instanceof CompositeBlock compositeBlock) {
                Optional<Block> foundBlock = findBlockByColorNested(compositeBlock.getBlocks(), color);
                if (foundBlock.isPresent()) {
                    return foundBlock;
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return findBlocksByMaterialNested(blocks, material);
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
        return countBlocksNested(blocks);
    }

    private int countBlocksNested(List<Block> blocks) {
        var count = 0;
        for (Block block : blocks) {
            if (block instanceof CompositeBlock compositeBlock) {
                count += countBlocksNested(compositeBlock.getBlocks());
            }

            count++;
        }
        return count;
    }
}