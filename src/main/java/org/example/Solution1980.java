package org.example;

//1980. Find Unique Binary String

//Суть нашей задачи в том что есть список уникальных бинарных
// строк одинаковой длины. Нужно найти любую другую бинарную строку
// такой же длины, которой нет в этом списке.
public class Solution1980 {
    //В Java строки (String) нельзя изменять.
    // Когда ты что-то добавляешь к строке,
    // Java создаёт новую строку, что медленно.

    //StringBuilder — это специальный класс,
    // который позволяет изменять строки быстрее.
    //.append => Добавляет строку

    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            result.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return result.toString();
    }
    /*
    * result.append(nums[0].charAt(0) == '0' ? '1' : '0');
      (условие) ? (если_True) : (если_False)
1️ Берём символ nums[i].charAt(i).
2️ Проверяем, равен ли он '0'.
*
Если да → ставим '1'.
Если нет → ставим '0'.
3 result.append('0'); → добавляем '0' в result.

*/
}
