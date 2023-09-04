/*
[PGS] 43105_정수 삼각형_lv3
https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=javascript
*/
function solution(triangle) {
  const length = triangle.length;
  triangle[1][0] = triangle[0][0] + triangle[1][0];
  triangle[1][1] = triangle[0][0] + triangle[1][1];

  for (let line = 2; line < length; line++) {
    for (let i = 0; i < line + 1; i++) {
      triangle[line][i] += Math.max(
        triangle[line - 1][i - 1] || 0,
        triangle[line - 1][i] || 0
      );
    }
  }
  return Math.max(...triangle[length - 1]);
}

const input = [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]];
console.log(solution(input));
