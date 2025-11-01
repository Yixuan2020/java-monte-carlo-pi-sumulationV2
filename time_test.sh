#!/bin/bash

#java -jar mc_pi.jar

iteration=8492
echo "Teste" ${iteration} "mal"
for((i=1;i<=iteration;i++))
do
    output=$(java -jar mc_pi_V0-2.jar)


    id=$(echo "$output" | grep -o -E '[0-9]+')

    echo $id >> time.csv

done

awk '{sum+=$1; count++} END{print sum/count}' time.csv
