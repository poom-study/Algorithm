/*
[BOJ] 20442_ㅋㅋ루ㅋㅋ_골드2
https://www.acmicpc.net/problem/20442
*/
const input = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split("");

const leftKCnt = [];
const rightKCnt = [];

let cnt = 0;
for (let word of input) {
  if (word === "K") cnt++;
  else leftKCnt.push(cnt);
}
cnt = 0;
for (let word of input.reverse()) {
  if (word === "K") cnt++;
  else rightKCnt.push(cnt);
}

rightKCnt.reverse();
let left = 0;
let right = rightKCnt.length - 1;
let answer = 0;
while (left <= right) {
  let result =
    right - left + 1 + 2 * Math.min(leftKCnt[left], rightKCnt[right]);
  answer = Math.max(answer, result);
  leftKCnt[left] < rightKCnt[right] ? (left += 1) : (right -= 1);
}
console.log(answer);
