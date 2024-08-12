package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.WallTestConfig.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class WallFindByMaterialTest {

    Wall wall;

    @BeforeEach
    void setUp() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(compositeBlock1);
        blocks.add(compositeBlock2);
        blocks.add(compositeBlock3);
        wall = new Wall(blocks);
    }

    @Test
    void should_return_1_composite_block_when_find_blocks_by_material_sandstone() {
        // given
        String material = "sandstone";

        // when
        List<Block> actual = wall.findBlocksByMaterial(material);

        // then
        assertAll(
                () -> assertThat(actual).hasSize(1),
                () -> assertThat(actual.getFirst()).isEqualTo(compositeBlock1)
        );
    }

    @Test
    void should_return_0_blocks_when_find_blocks_by_material_unknown() {
        // given
        String material = "unknown";

        // when
        List<Block> actual = wall.findBlocksByMaterial(material);

        // then
        assertThat(actual).isEmpty();
    }

    @Test
    void should_return_8_blocks_when_find_blocks_by_material_stone() {
        // given
        String material = "stone";

        // when
        List<Block> actual = wall.findBlocksByMaterial(material);

        // then
        List<Block> expected = List.of(block1, block2, block1, block1, block2, block1, block2, compositeBlock3);
        assertAll(
                () -> assertThat(actual).hasSize(8),
                () -> assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
        );
    }

    @Test
    void should_return_5_blocks_when_find_blocks_by_material_brick() {
        // given
        String material = "brick";

        // when
        List<Block> actual = wall.findBlocksByMaterial(material);

        // then
        List<Block> expected = List.of(block3, compositeBlock2, block3, compositeBlock2, block3);
        assertAll(
                () -> assertThat(actual).hasSize(5),
                () -> assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
        );
    }
}