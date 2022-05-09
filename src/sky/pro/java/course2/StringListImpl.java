package sky.pro.java.course2;

import sky.pro.java.course2.exceptions.AddingNullException;
import sky.pro.java.course2.exceptions.IndexOutBoundsException;
import sky.pro.java.course2.exceptions.NotFound;
import sky.pro.java.course2.exceptions.NullPointerException;

public class StringListImpl implements StringList {
    String[] arrayString;
    int indexOfElement = 0;

    public StringListImpl(int sizeOfStorage) {
        this.arrayString = new String[sizeOfStorage];
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new AddingNullException("Добавление Null!");
        }
        if ((indexOfElement) == arrayString.length) {
            throw new IndexOutBoundsException("В хранилище нет места.");
        }
        arrayString[indexOfElement] = item;
        indexOfElement++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if ((indexOfElement) == arrayString.length) {
            throw new IndexOutBoundsException("В хранилище нет места.");
        }
        if (index >= indexOfElement) {
            throw new IndexOutBoundsException("Введен некорректный индекс.");
        }
        for (int i = indexOfElement - 1; i >= index; i--) {
            arrayString[i + 1] = arrayString[i];
        }
        arrayString[index] = item;
        indexOfElement++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index >= indexOfElement || index >= arrayString.length) {
            throw new IndexOutBoundsException("Введен некорректный индекс.");
        }
        arrayString[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int indexOfSearchableElement = -1;
        for (int i = 0; i < indexOfElement; i++) {
            if (arrayString[i].equals(item)) {
                indexOfSearchableElement = i;
            }
        }
        if (indexOfSearchableElement == -1) {
            throw new NotFound("Элемент не найден.");
        }
        for (int j = indexOfSearchableElement; j < indexOfElement - 1; j++) {
            arrayString[j] = arrayString[j + 1];
        }
        arrayString[indexOfElement - 1] = null;
        indexOfElement--;
        return item;
    }

    @Override
    public String remove(int index) {
        if (index >= indexOfElement) {
            throw new IndexOutBoundsException("Введен некорректный индекс.");
        }
        String removedElement = arrayString[index];
        for (int i = index; i < indexOfElement - 1; i++) {
            arrayString[i] = arrayString[i + 1];
        }
        arrayString[indexOfElement - 1] = null;
        indexOfElement--;
        return removedElement;
    }

    @Override
    public boolean contains(String item) {
        boolean rezult = false;
        for (int i = 0; i < indexOfElement; i++) {
            if (arrayString[i].equals(item)) {
                rezult = true;
            }
        }
        return rezult;
    }

    @Override
    public int indexOf(String item) {
        int indexOfSearchableElement = -1;
        for (int i = 0; i < indexOfElement; i++) {
            if (arrayString[i].equals(item)) {
                indexOfSearchableElement = i;
                break;
            }
        }
        return indexOfSearchableElement;
    }

    @Override
    public int lastIndexOf(String item) {
        int indexOfSearchableElement = -1;
        for (int i = indexOfElement-1; i >= 0; i--) {
            if (arrayString[i].equals(item)) {
                indexOfSearchableElement = i;
                break;
            }
        }
        return indexOfSearchableElement;
    }

    @Override
    public String get(int index) {
        if (index >= indexOfElement) {
            throw new IndexOutBoundsException("Введен некорректный индекс.");
        }
        return arrayString[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        boolean rezult = true;
        if (otherList.size() != indexOfElement) {
            rezult = false;
            return rezult;
        }
        for (int i = 0; i < indexOfElement; i++) {
            if (otherList.get(i) == null) {
                throw new NullPointerException("Обращение к NULL!");
            }
            if (!(arrayString[i].equals(otherList.get(i)))) {
                rezult = false;
                return rezult;
            }
        }
        return rezult;
    }

    @Override
    public int size() {
        return indexOfElement;
    }

    @Override
    public boolean isEmpty() {
        boolean result = false;
        if (indexOfElement == 0) {
            result = true;
        }
        return result;
    }

    @Override
    public void clear() {
        int counterForClear = indexOfElement;
        for (int i = 0; i < counterForClear; i++) {
            arrayString[i] = null;
            indexOfElement--;
        }
    }

    @Override
    public String[] toArray() {
        String[] returnedArray = new String[indexOfElement];
        for (int i = 0; i < indexOfElement; i++) {
            returnedArray[i] = arrayString[i];
        }
        return returnedArray;
    }
}
