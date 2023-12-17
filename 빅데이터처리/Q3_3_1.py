str = "X-DSPAM-Confidence:0.8475"
colon = str.find(':')

if colon != -1:
    num = str[colon + 1:].strip()
    print(float(num))
else:
    print("no value")