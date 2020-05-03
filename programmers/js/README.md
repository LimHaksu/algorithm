### 자바스크립트 알고리즘용 도구들...

## set
```javascript
const set = new Set();  

set.add(e);  
  
set.delete(e);  

if(set.has(e)){  
    // todo...  
}  
  
set.forEach(e=>{  
    // todo...  
})  
```  
  
## map
```javascript
const map = new Map();

map.set(key, value);
  
map.get(key);

if(map.has(key)){
    // todo...
}

for(key in map.keys()){
    // todo...
}

for(value in map.values()){
    // todo...
}

for([key, value] in map.entries()){
    // todo...
}
```
  
## stack
```javascript
let stack = [];

stack.push(e);

let top = stack.pop();

let top = stack[stack.length-1];
```

## queue
```javascript
let queue = [];

queue.push(e);

let front = queue.shift();

let front = queue[0];
```

## priority queue
```javascript
???
```

## sort
```javascript
let arr = [{num1:1, num2:2},{num1:1, num2:1}];
// num1 내림차순정렬, num1이 같으면 num2 오름차순 정렬
arr.sort((a, b, ) => {
    if (a.num1 > b.num2) {
        return -1;
    } else if (a.num1 < b.num1) {
        return 1;
    } else {
        return a.num2 - b.num2;
    }
});
```