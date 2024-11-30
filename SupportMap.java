package pacman;

public final class SupportMap {
    private static final int[][] intMap = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0}, {0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0}, {0, 3, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 3, 0}, {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0}, {0, 2, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 2, 0}, {0, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 0, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 0}, {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 2, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 2, 0, 1, 0, 1, 1, 5, 1, 1, 0, 1, 0, 2, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 2, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 2, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 2, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0}, {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0}, {0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0}, {0, 3, 2, 2, 0, 2, 2, 2, 2, 2, 2, 4, 2, 2, 2, 2, 2, 2, 0, 2, 2, 3, 0}, {0, 0, 0, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 2, 0, 0, 0}, {0, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 0, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 0}, {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0}, {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    public SupportMap() {
    }

    private static CS15SquareType[][] convertToSquareType(int[][] intMap) {
        CS15SquareType[][] enumMap = new CS15SquareType[intMap.length][intMap[0].length];

        for(int i = 0; i < intMap.length; ++i) {
            for(int j = 0; j < intMap[0].length; ++j) {
                CS15SquareType val = null;
                switch (intMap[i][j]) {
                    case 0:
                        val = CS15SquareType.WALL;
                        break;
                    case 1:
                        val = CS15SquareType.FREE;
                        break;
                    case 2:
                        val = CS15SquareType.DOT;
                        break;
                    case 3:
                        val = CS15SquareType.ENERGIZER;
                        break;
                    case 4:
                        val = CS15SquareType.PACMAN_START_LOCATION;
                        break;
                    case 5:
                        val = CS15SquareType.GHOST_START_LOCATION;
                        break;
                    default:
                        String error = "The board representation must have been updated.\nPlease alert the TA staff that their support code has broken.";
                        throw new IllegalArgumentException(error);
                }

                enumMap[i][j] = val;
            }
        }

        return enumMap;
    }

    public static final CS15SquareType[][] getSupportMap() {
        return convertToSquareType(intMap);
    }

    public static final CS15BoardLocation[][] getMap() {
        return convertToBoardLocation(intMap);
    }

    private static CS15BoardLocation[][] convertToBoardLocation(int[][] intMap) {
        CS15BoardLocation[][] enumMap = new CS15BoardLocation[intMap.length][intMap[0].length];

        for(int i = 0; i < intMap.length; ++i) {
            for(int j = 0; j < intMap[0].length; ++j) {
                CS15BoardLocation val = null;
                switch (intMap[i][j]) {
                    case 0:
                        val = CS15BoardLocation.WALL;
                        break;
                    case 1:
                        val = CS15BoardLocation.FREE;
                        break;
                    case 2:
                        val = CS15BoardLocation.DOT;
                        break;
                    case 3:
                        val = CS15BoardLocation.ENERGIZER;
                        break;
                    case 4:
                        val = CS15BoardLocation.PACMAN_START_LOCATION;
                        break;
                    case 5:
                        val = CS15BoardLocation.GHOST_START_LOCATION;
                        break;
                    default:
                        String error = "The board representation must have been updated.\nPlease alert the TA staff that their support code has broken.";
                        throw new IllegalArgumentException(error);
                }

                enumMap[i][j] = val;
            }
        }

        return enumMap;
    }
}
