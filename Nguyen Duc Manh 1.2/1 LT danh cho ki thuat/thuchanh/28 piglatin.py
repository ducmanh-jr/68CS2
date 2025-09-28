# piglatin 
def pig(tu):
    nguyenam = {'a','e','u','o','i'}
    if tu [0].lower() in nguyenam:
        return tu + 'way'
    else:
        return tu[1:] + tu[0] +'ay'
chuyendoi = lambda cau: ' '.join([pig(tu) for tu in cau.split()])

if __name__ == "__main__":
    cauthu = "nguyen duc manh asd "
    print(f"chuyen doi '{cauthu}' sang piglatin '{chuyendoi(cauthu)}'")
