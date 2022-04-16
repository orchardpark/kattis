import sys

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    fastpow = []
    mod = 1000000007
    inp = sys.stdin.readline()
    zeroes = [0]*len(inp)
    questions = [0]*len(inp)
    questionsB = [0]*len(inp)
    zeroSum = 0
    questionsSum = 0
    questionsBSum = 0
    for i in range(len(inp)-1, -1, -1):
        zeroes[i]=zeroSum
        questions[i]=questionsSum
        if inp[i] == '0':
            zeroSum += 1
        elif inp[i] == '?':
            questionsSum += 1

    for i in range(len(inp)):
        questionsB[i] = questionsBSum
        if inp[i] == '?':
            questionsBSum += 1

    fastpow.append(1)
    for i in range(1, questionsSum+1):
        fastpow.append((fastpow[i-1]*2)%mod)
    tsum = 0
    for i in range(len(inp)):
        if inp[i] == '1' or inp[i] == '?':
            factor = 1
            if questionsB[i]>0:
                factor = fastpow[questionsB[i]]
            zeroesPart = zeroes[i]
            if questions[i] ==0:
                tsum = (tsum + zeroesPart*factor) % mod
            else:
                questionsPart = fastpow[questions[i]-1] * ((questions[i]+2*zeroesPart)*factor%mod)
                tsum = (tsum + questionsPart) % mod

    print(tsum)
