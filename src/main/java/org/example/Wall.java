package org.example;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall() {
    }

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return findBlockByColorNested(blocks, color).findFirst();
    }

    private Stream<Block> findBlockByColorNested(List<Block> blocks, String color) {
        return blocks.stream()
                .flatMap(b -> b instanceof CompositeBlock compositeBlock ?
                        Stream.concat(Stream.of(b), findBlockByColorNested(compositeBlock.getBlocks(), color)) :
                        Stream.of(b))
                .filter(block -> color.equals(block.getColor()));
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return findBlocksByMaterialNested(blocks, material).toList();
    }

    private Stream<Block> findBlocksByMaterialNested(List<Block> blocks, String material) {
        return blocks.stream()
                .flatMap(b -> b instanceof CompositeBlock compositeBlock ?
                        Stream.concat(Stream.of(b), findBlocksByMaterialNested(compositeBlock.getBlocks(), material)) :
                        Stream.of(b))
                .filter(b -> b.getMaterial().equalsIgnoreCase(material));
    }

    @Override
    public int count() {
        return (int) countBlocksNested(blocks).count();
    }

    private Stream<Block> countBlocksNested(List<Block> blocks) {
        return blocks.stream()
                .flatMap(b -> b instanceof CompositeBlock compositeBlock ?
                        Stream.concat(Stream.of(b), countBlocksNested(compositeBlock.getBlocks())) :
                        Stream.of(b));

    }
}