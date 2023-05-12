package main

import (
	"encoding/csv"
	"fmt"
	"io"
	"math"
	"os"
	"strconv"
)

func main() {
	file, err := os.Open("table.csv")
	if err != nil {
		fmt.Println("Ошибка при открытии файла")
		panic(err)
	}
	defer file.Close()

	reader := csv.NewReader(file)
	reader.Comma = ';'

	var data [][]string
	for {
		line, err := reader.Read()
		if err != nil {
			if err == io.EOF {
				break
			}
			fmt.Println("Ошибка при чтении файла")
			panic(err)
		}
		data = append(data, line)
	}

	var info [][]string                             //информация о количестве продаж и доле
	sum := 0                                        //общая выручка магазина
	maxProductAmount, _ := strconv.Atoi(data[1][4]) //наибольшее количество проданного товара
	maxProductAmountName := data[1][2]              //название товара, который был продан максимальное количество раз
	maxProductSum, _ := strconv.Atoi(data[1][6])    //наибольшая выручка
	maxProductSumName := data[1][2]                 //название товара с наибольшей выручкой

	for i := 1; i < len(data); i++ {
		//общая выручка магазина
		thisProductSum, _ := strconv.Atoi(data[i][6])
		sum += thisProductSum

	}
	for i := 1; i < len(data); i++ {
		thisProductSum, _ := strconv.Atoi(data[i][6])                              //выручка с этого товара
		thisProductName := data[i][2]                                              //название
		thisProductAmount := data[i][4]                                            //количество
		thisProductPartFloat := float64(thisProductSum) / float64(sum)             //находим часть
		thisProductPartCeil := math.Ceil(thisProductPartFloat*1000) / 10           //округление до %
		thisProductPart := fmt.Sprint(thisProductPartCeil)                         //часть в строку
		infoAbout := []string{thisProductName, thisProductAmount, thisProductPart} //записываем в массив
		info = append(info, infoAbout)                                             //добавляем в общее инфо

		//товар, который был продан наибольшее количество раз
		thisAmount, _ := strconv.Atoi(thisProductAmount)
		if thisAmount > maxProductAmount {
			maxProductAmount = thisAmount
			maxProductAmountName = data[i][2]
		}

		//товар, который принес наибольшую выручку
		if thisProductSum > maxProductSum {
			maxProductSum = thisProductSum
			maxProductSumName = data[i][2]
		}
	}

	fmt.Printf("Общая выручка магазина = %v", sum)
	fmt.Println()
	fmt.Printf("Товар %v был продан максимальное количество раз : %v", maxProductAmountName, maxProductAmount)
	fmt.Println()
	fmt.Printf("Товар %v принес наибольшую выручку : %v", maxProductSumName, maxProductSum)
	fmt.Println()
	for _, part := range info {
		fmt.Println()
		fmt.Printf("Товар %v был продан %v раз и составляет ~%v%% от общей выручки", part[0], part[1], part[2])
		fmt.Println()
	}
}
