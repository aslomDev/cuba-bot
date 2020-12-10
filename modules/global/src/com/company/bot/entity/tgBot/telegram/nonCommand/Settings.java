package com.company.bot.entity.tgBot.telegram.nonCommand;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Пользовательские настройки
 */
@Getter
@EqualsAndHashCode
public class Settings {

    /**
     * Минимальное число, используемое в заданиях
     */
    private int min;

    /**
     * Максимальное число, используемое в заданиях
     */
    private int max;

    /**
     * Количество страниц выгружаемого файла
     */
    private int listCount;

    /**
     * Количество уникальных задач, которыне можно сформировать с использованием интервала чисел от min до max
     */
    @EqualsAndHashCode.Exclude
    private int uniqueTaskCount;

    public Settings(int min, int max, int listCount) {
        this.min = SettingsAssistant.calculateMin(min, max);
        this.max = SettingsAssistant.calculateMax(min, max);
        this.listCount = SettingsAssistant.calculateListCount(listCount);
        this.uniqueTaskCount = SettingsAssistant.calculateUniqueTaskCount(this.min, this.max);
    }

    public int getListCount() {
        return listCount;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setListCount(int listCount) {
        this.listCount = listCount;
    }

    public void setUniqueTaskCount(int uniqueTaskCount) {
        this.uniqueTaskCount = uniqueTaskCount;
    }

    public int getUniqueTaskCount() {
        return uniqueTaskCount;
    }
}