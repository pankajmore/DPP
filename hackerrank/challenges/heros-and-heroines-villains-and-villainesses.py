import random
import nltk
def gender_features(word):
    return {'last_letter': word[-1]}

names = ([(name, 'Male') for name in nltk.corpus.names.words('male.txt')] + [(name, 'Female') for name in nltk.corpus.names.words('female.txt')])

random.shuffle(names)

train_set = [(gender_features(n), g) for (n,g) in names]
classifier = nltk.NaiveBayesClassifier.train(train_set)

N = int(raw_input())
for _ in xrange(N):
    s = raw_input()
    print classifier.classify(gender_features(s))
