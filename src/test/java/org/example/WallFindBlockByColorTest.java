package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.WallTestConfig.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class WallFindBlockByColorTest {

    @Test
    void should_return_block_when_find_block_by_existing_color() {
        // given
        List<Block> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        Wall wall = new Wall(blocks);

        // when
        String color = "blue";
        Optional<Block> actual = wall.findBlockByColor(color);

        // then
        assertAll(
                () -> assertThat(actual.isPresent()).isTrue(),
                () -> assertThat(actual.get()).isEqualTo(block1)
        );
    }

    @Test
    void should_return_empty_optional_when_find_block_by_not_existing_color() {
        // given
        List<Block> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        Wall wall = new Wall(blocks);

        // when
        String color = "green";
        Optional<Block> actual = wall.findBlockByColor(color);

        // then
        assertThat(actual.isPresent()).isFalse();
    }

    @Test
    void should_return_any_block_when_find_block_by_existing_color() {
        // given
        List<Block> blocks = new ArrayList<>();
        blocks.add(compositeBlock2);
        Wall wall = new Wall(blocks);

        // when
        String color = "blue";
        Optional<Block> actual = wall.findBlockByColor(color);

        // then
        assertAll(
                () -> assertThat(actual.isPresent()).isTrue(),
                () -> assertThat(actual.get().getColor()).isEqualTo(color)
        );
    }
}