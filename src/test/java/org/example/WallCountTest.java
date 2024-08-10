package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.WallTestConfig.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WallCountTest {

    @Test
    void should_return_0_when_count_wall_has_0_blocks() {
        // given
        List<Block> blocks = new ArrayList<>();
        Wall wall = new Wall(blocks);

        // when
        int actual = wall.count();

        // then
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void should_return_2_when_count_wall_has_block_and_composite_block() {
        // given
        List<Block> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(compositeBlock3);
        Wall wall = new Wall(blocks);

        // when
        int actual = wall.count();

        // then
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void should_return_1_when_count_wall_has_1_block() {
        // given
        List<Block> blocks = new ArrayList<>();
        blocks.add(block1);
        Wall wall = new Wall(blocks);

        // when
        int actual = wall.count();

        // then
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void should_return_4_when_count_wall_has_composite_block_with_3_blocks() {
        // given
        List<Block> blocks = new ArrayList<>();
        blocks.add(compositeBlock2);
        Wall wall = new Wall(blocks);

        // when
        int actual = wall.count();

        // then
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void should_return_6_when_count_wall_has_composite_block_with_block_and_composite_block() {
        // given
        List<Block> blocks = new ArrayList<>();
        blocks.add(compositeBlock1);
        Wall wall = new Wall(blocks);

        // when
        int actual = wall.count();

        // then
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void should_return_14_when_count_wall_has_3_blocks_and_3_composite_blocks() {
        // given
        List<Block> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(compositeBlock1);
        blocks.add(compositeBlock2);
        blocks.add(compositeBlock3);
        Wall wall = new Wall(blocks);

        // when
        int actual = wall.count();

        // then
        int expected = 14;
        assertEquals(expected, actual);
    }
}