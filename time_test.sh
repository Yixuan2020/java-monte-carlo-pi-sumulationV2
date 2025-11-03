#!/bin/bash

#java -jar mc_pi.jar

iteration=500
echo "Teste" ${iteration} "mal"
for((i=1;i<=iteration;i++))
do
    output=$(java -jar mc_pi_V0-3.jar)


    id=$(echo "$output" | grep -o -E '[0-9]+')

    echo $id >> time.csv

done

awk '{sum+=$1; count++} END{print sum/count}' time.csv
