<h2><a href="https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1">Job Sequencing Problem</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 14pt;">You are given three arrays: <code>id</code>, <code>deadline</code>, and <code>profit</code>, where each job is associated with an ID, a deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.</span></p>
<p><span style="font-size: 14pt;">Your task is to find:</span></p>
<ol>
<li><span style="font-size: 14pt;">The maximum number of jobs that can be completed within their deadlines.</span></li>
<li><span style="font-size: 14pt;">The total maximum profit earned by completing those jobs.</span></li>
</ol>
<p><span style="font-size: 14pt;"><strong>Examples :</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>id = [1, 2, 3, 4], deadline = [4, 1, 1, 1], profit = [20, 1, 40, 30]
<strong>Output: </strong>[2, 60]<strong>
Explanation: </strong>Job<sub>1</sub> and Job<sub>3 </sub>can be done with maximum profit of 60 (20+40).
</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>id = [1, 2, 3, 4, 5], deadline = [2, 1, 2, 1, 1], profit = [100, 19, 27, 25, 15]
<strong>Output: </strong>[2, 127]<strong>
Explanation: </strong>Job<sub>1</sub> and Job<sub>3</sub> can be done with maximum profit of 127 (100+27).</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>id = [1, 2, 3, 4], deadline = [3, 1, 2, 2], profit = [50, 10, 20, 30]
<strong>Output: </strong>[3, 100]<strong>
Explanation: </strong>Job<sub>1</sub>, Job<sub>3</sub> and Job<sub>4</sub> can be completed with a maximum profit of 100 (50 + 20 + 30).</span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong><br>1 &lt;=&nbsp; id.size() == deadline.size() == profit.size() &lt;= 10<sup>5</sup><br>1 &lt;= id[i], deadline[i] &lt;= id.size()<br>1 &lt;= profit &lt;= 500</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Flipkart</code>&nbsp;<code>Accolite</code>&nbsp;<code>Microsoft</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;<code>Greedy</code>&nbsp;<code>Algorithms</code>&nbsp;