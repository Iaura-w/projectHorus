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
        return getBlockStream(blocks)
                .filter(block -> color.equals(block.getColor()))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return getBlockStream(blocks)
                .filter(b -> b.getMaterial().equalsIgnoreCase(material))
                .toList();
    }

    @Override
    public int count() {
        return (int) getBlockStream(blocks).count();
    }

    private Stream<Block> getBlockStream(List<Block> blocks) {
        return blocks.stream()
                .flatMap(b -> b instanceof CompositeBlock compositeBlock ?
                        Stream.concat(Stream.of(b), getBlockStream(compositeBlock.getBlocks())) :
                        Stream.of(b));
    }
}