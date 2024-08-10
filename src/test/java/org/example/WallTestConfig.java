package org.example;

import java.util.List;

class WallTestConfig {

    static Block block1 = new Block() {
        @Override
        public String getColor() {
            return "blue";
        }

        @Override
        public String getMaterial() {
            return "stone";
        }
    };
    static Block block2 = new Block() {
        @Override
        public String getColor() {
            return "red";
        }

        @Override
        public String getMaterial() {
            return "stone";
        }
    };
    static Block block3 = new Block() {
        @Override
        public String getColor() {
            return "red";
        }

        @Override
        public String getMaterial() {
            return "brick";
        }
    };

    static CompositeBlock compositeBlock1 = new CompositeBlock() {
        @Override
        public List<Block> getBlocks() {
            return List.of(block1, compositeBlock2);
        }

        @Override
        public String getColor() {
            return "brown";
        }

        @Override
        public String getMaterial() {
            return "sandstone";
        }
    };

    static CompositeBlock compositeBlock2 = new CompositeBlock() {
        @Override
        public List<Block> getBlocks() {
            return List.of(block1, block2, block3);
        }

        @Override
        public String getColor() {
            return "brown";
        }

        @Override
        public String getMaterial() {
            return "brick";
        }
    };
    static CompositeBlock compositeBlock3 = new CompositeBlock() {
        @Override
        public List<Block> getBlocks() {
            return List.of();
        }

        @Override
        public String getColor() {
            return "green";
        }

        @Override
        public String getMaterial() {
            return "stone";
        }
    };
}
