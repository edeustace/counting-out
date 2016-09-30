# counting-out 

An sbt project that calculates the last position left for a given circle size `n` and a step size `k`.

For example: 
```
n = 4
k = 2
circle = 1,2,3,4
step and remove => 1,|,3,4
step and remove => 1,|,3,|
step and remove => 1,|,|,|
last position left = 1
```

# Install 

```shell 
git clone git@github.com:edeustace/counting-out.git
cd counting-out
sbt
```

# Test
```sh
sbt test
```

# Run

```sh 
sbt "run 4 2"
sbt "run 3 1"
```

