import random
import string

# length of string more than 100000 numbers

def GenManyStrings(count):
	while count > 0:
		text = ""
		randHeadder = random.randint(1, 100)
		if randHeadder < 37:
			text += "sms:"
		elif randHeadder < 67 and randHeadder >= 37:
			text += "tel:"
		elif randHeadder < 95 and randHeadder >= 67:
			text += "fax:"
		elif randHeadder >= 95:
			text += "trash:"
		randCountOfNumbers = random.randint(1, 3)
		numbers = ""
		while randCountOfNumbers > 0:
			rand = random.randint(1, 100)
			number = "+"
			while len(number) != 12:
				if rand > 95:
					number += random.choice(string.ascii_lowercase + string.digits)
				else: 
					number += str(random.randint(1,9))
			if randCountOfNumbers > 1:
				number += ","
			else:
				number += ";"
			numbers += number
			randCountOfNumbers = randCountOfNumbers - 1
		text += numbers
		randText = random.randint(1,5)
		rand = random.randint(1,100)
		rand2 = random.randint(1, 64)
		if randHeadder < 32:
			if rand < 60:
				text += "?body="
				while rand2 > 0:
					text += random.choice(string.ascii_lowercase + string.digits + '%' + ',' + '.' + '?' + '!')	
					rand2 = rand2 - 1
			elif rand >= 95 and rand < 98:
				n = random.randint(64,80)
				while n > 0:
					text += random.choice(string.ascii_lowercase + string.digits + '%' + ',' + '.' + '?' + '!')
					n = n - 1
		elif randHeadder >= 32:
			if rand < 95:
				text += ""
			else:
				while rand2 > 0:
					text += random.choice(string.ascii_lowercase + string.digits + '%' + ',' + '.' + '?' + '!')
					rand2 = rand2 - 1
		text += '\n'
		mfile.write(text)
		count = count - 1


def GenManyNumbers(count):
	strings = 10
	while strings > 0:
		text = ""
		randHeadder = random.randint(1, 100)
		if randHeadder < 37:
			text += "sms:"
		elif randHeadder < 67 and randHeadder >= 37:
			text += "tel:"
		elif randHeadder < 95 and randHeadder >= 67:
			text += "fax:"
		elif randHeadder >= 95:
			text += "trash:"
		randCountOfNumbers = random.randint(count / 2, count)
		numbers = ""
		while randCountOfNumbers > 0:
			rand = random.randint(1, 10000)
			number = "+"
			while len(number) != 12:
				if rand > 9990:
					number += random.choice(string.ascii_lowercase + string.digits)
				else: 
					number += str(random.randint(1,9))
			if randCountOfNumbers > 1:
				number += ","
			else:
				number += ";"
			numbers += number
			randCountOfNumbers = randCountOfNumbers - 1
		text += numbers
		randText = random.randint(1,5)
		rand = random.randint(1,100)
		rand2 = random.randint(1, 64)
		if randHeadder < 32:
			if rand < 60:
				text += "?body="
				while rand2 > 0:
					text += random.choice(string.ascii_lowercase + string.digits + '%' + ',' + '.' + '?' + '!')	
					rand2 = rand2 - 1
			elif rand >= 95 and rand < 98:
				n = random.randint(64,1000)
				while n > 0:
					text += random.choice(string.ascii_lowercase + string.digits + '%' + ',' + '.' + '?' + '!')
					n = n - 1
		elif randHeadder >= 32:
			if rand < 95:
				text += ""
			else:
				while rand2 > 0:
					text += random.choice(string.ascii_lowercase + string.digits + '%' + ',' + '.' + '?' + '!')
					rand2 = rand2 - 1
		text += '\n'
		mfile.write(text)
		strings = strings - 1
		
		
args = input().split()
mfile = open(str(args[1]), "w")
if int(args[0]) == 0: 	
	GenManyStrings(int(args[2]))
elif int(args[0]) == 1:
	GenManyNumbers(int(args[2]));
mfile.close()
print("Write in file succesfull")
