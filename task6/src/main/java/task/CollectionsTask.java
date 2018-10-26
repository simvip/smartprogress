package task;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Ivan Sliusar on 17.10.2018.
 * Red Line Soft corp.
 */
public class CollectionsTask {

    /**
     * Задан массив чисел со значениями 0 и 1.
     * Нужно проверить, что все значения в массиве равны 1.
     * Например, [0, 1] - false, [1, 1] - true,
     */
    public boolean checkingMassiveForAllValuesEqualsOne(int[] inputData) {
        Set<Integer> set = IntStream.of(inputData).boxed().collect(Collectors.toSet());
        return (set.size() == 1) && (set.contains(1));
    }

    /**
     * Задан массив чисел со значениями 0 и 1.
     * Нужно проверить, что в массиве есть последовательности из трех и больше единиц.
     * Например, [0, 1, 1] - false, [1, 1, 1] - true,
     */
    public boolean checkingMassiveOnSequence(int[] inputData) {
        int maxSequnse = 0;
        for (int i = 0; i < inputData.length; i++) {
            if (maxSequnse >= 3) return true;
            if (inputData[i] == 0)
                maxSequnse = 0;
            else
                maxSequnse++;
        }
        return false;
    }

    /**
     * Задан числовой массив. Нужно проверить, что все значения в массиве одинаковые.
     * Например, [0, 0, 0] - true, [1, 1, 1] - true, [0, 1, 1] - false
     *
     * @param inputData int[]
     * @return boolean.
     */
    public boolean checkingMassiveOnSimilarValues(int[] inputData) {
        Set<Integer> set = IntStream.of(inputData).boxed().collect(Collectors.toSet());
        return set.size() == 1;
    }

    /**
     * Задано предложение. Нужно переставить слова в обратно порядке.
     * Например, "программируй и зарабатывай" -> "зарабатывай и программируй"
     *
     * @param inputData int[]
     * @return boolean.
     */
    public String reversString(String inputData) {
        List<String> list = Arrays.asList(
                inputData.split(" ")
        );
        Collections.reverse(list);
        return String.join(" ", list);
    }

    /**
     * Задан числовой массив. Нужно реализовать метод кольцевого сдвига на N. int[] shift().
     * Не использовать дополнительный массив.
     * Например, [1, 2, 3, 4, 5] - shift(2) - [4, 5, 1, 2, 3]
     *
     * @param inputData int[]
     * @return boolean.
     */
    public int[] ringShift(int[] inputData, int n) {
        for (int i = 0; i < n; i++) {
            int endValue = inputData[inputData.length - 1];
            int maxIndexLessThenOne = inputData.length - 2;
            while (maxIndexLessThenOne >= 0) {
                inputData[maxIndexLessThenOne + 1] = inputData[maxIndexLessThenOne];
                maxIndexLessThenOne--;
            }
            inputData[0] = endValue;
        }
        return inputData;
    }

    /**
     * Задан квадратный массив. Нужно проверить, что в нем есть выигрышные варианты для игры крестики-нолики.
     *
     * @param inputData int[]
     * @return boolean.
     */
    public boolean tickTackGame(int[][] inputData) {
        int maxIndex = inputData.length - 1;
        //check the diagonal of playing field.
        if (checkLine(inputData, maxIndex, 0, 0, 1, 1) || checkLine(inputData, maxIndex, 0, maxIndex, 1, -1))
            return true;

        //check horizontal and vertical line
        for (int i = 0; i < maxIndex; i++) {
            if (checkLine(inputData, maxIndex, i, 0, 0, 1) || checkLine(inputData, maxIndex, 0, i, 1, 0)) return true;
        }

        return false;
    }

    private boolean checkLine(int[][] fild, int maxIndex, int startX, int startY, int deltaX, int deltaY) {
        boolean haveWon = false;
        while (startX != maxIndex && startY != maxIndex) {
            haveWon = fild[startX][startY] == 1;
            if (!haveWon) {
                break;
            }
            startX += deltaX;
            startY += deltaY;
        }
        return haveWon;
    }

    /**
     * Реализован банкомат размена денег.
     * Автомат принимает бумажную купюру и обменивает на монеты.
     * Метод должен возвращать список всех возможных вариантов размены купюры.
     *
     * @return int.
     */
    public int makingChange(int banknotes[], int numOfbanknotes, int amount) {
        if (amount == 0)
            return 1;
        if (amount < 0)
            return 0;
        if (numOfbanknotes <= 0 && amount >= 1)
            return 0;

        return makingChange(banknotes, numOfbanknotes - 1, amount) +
                makingChange(banknotes, numOfbanknotes, amount - banknotes[numOfbanknotes - 1]);
    }

    /**
     * Задан двойной массив, заполненный нулями и единицами.
     * Нужно определить самое большое множество единиц.
     * Множеством считается объединение единиц, которые соприкасаются друг с другом.
     * Диагональное соприкосновение не учитывать.
     *
     * @param inputData int[][]
     * @return int.
     */
    public int defineMaxSetSize(int[][] inputData) {
        ArrayList<Set<Peak>> storageSet = new ArrayList<>();
        int maxJ = inputData[0].length;
        for (int i = 0; i < inputData.length; i++) {
            for (int j = 0; j < maxJ; j++) {
                if (inputData[i][j] == 0) continue;
                Peak newPeak = new Peak(i, j);
                Boolean matchFound = false;
                for (Set<Peak> currentSet :
                        storageSet) {
                    for (Peak currentPeak :
                            currentSet) {
                        if (currentPeak.BelongThisSet(newPeak)) {
                            currentSet.add(newPeak);
                            matchFound = true;
                            break;
                        }
                    }
                    if (matchFound) break;
                }
                if (!matchFound) {
                    HashSet<Peak> e = new HashSet<>();
                    e.add(newPeak);
                    storageSet.add(e);
                }
            }
        }
        int maxSize = 0;
        for (Set<Peak> currentSet :
                storageSet) {
            maxSize = Math.max(maxSize, currentSet.size());
        }
        return maxSize;
    }

    /**
     * Задан двойной массив из единиц и нулей.
     * Нужно найти минимальный путь от точки А до точки В.
     * Двигаться можно только по единицам и только по вертикали или горизонтали.
     *
     * @param inputData  int[][]
     * @param finishPeak Peak
     * @param start      Peak
     * @return int.
     */
    public int definePath(Peak start, Peak finishPeak, int[][] inputData) {
        int count = 0;
        Set<Peak> machedPeak = new HashSet<>();
        Queue<Peak> queue = new LinkedList<>();
        queue.offer(start);
        while (queue.peek() != null) {
            Peak currentPeak = queue.poll();
            if (currentPeak.equals(finishPeak)) {
                return currentPeak.getLayer();
            }
            addChild(inputData, queue, machedPeak, currentPeak, 1, 0);
            addChild(inputData, queue, machedPeak, currentPeak, -1, 0);
            addChild(inputData, queue, machedPeak, currentPeak, 0, 1);
            addChild(inputData, queue, machedPeak, currentPeak, 0, -1);
            count++;
        }
        return 0;
    }

    private void addChild(int[][] inputData, Queue<Peak> queue, Set<Peak> machedPeak, Peak parentPeak, int deltaX, int deltaY) {
        int maxIndexX = inputData.length - 1;
        int maxY = inputData[0].length - 1;
        int newX = parentPeak.x + deltaX;
        int newY = parentPeak.y + deltaY;

        if ((newX >= 0 && newX <= maxIndexX) && (newY >= 0 && newY <= maxY) && (inputData[newX][newY] == 1)) {
            Peak childPeak = new Peak(newX, newY);
            childPeak.setLayer(parentPeak.getLayer() + 1);
            if (!machedPeak.contains(childPeak)) {
                queue.offer(childPeak);
                machedPeak.add(childPeak);
            }
        }
    }

    /**
     * Задан одномерный массив. Нужно найти все возможные варианты перестановок этого массива.
     *@param rsl List<String> значения всевозможных перестановок
     * @param str        String строка для поиска.
     * @param startIndex int начальный индекс строки.
     * @param endIndex   int конечный индекс строки.
     * @return int.
     */
    public int permutation(List<String> rsl, String str, int startIndex, int endIndex) {

        if (startIndex == endIndex){
            System.out.println(str);
            rsl.add(str);
        }
        else {
            for (int i = startIndex; i <= endIndex; i++) {
                str = swap(str, startIndex, i);
                permutation(rsl, str, startIndex + 1, endIndex);
                str = swap(str, startIndex, i);
            }
        }

        return 0;
    }

    private String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}


