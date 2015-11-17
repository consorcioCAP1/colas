function customFilter(subString, value) {
	if (subString.length >= 1) {
		if (value.indexOf(subString) != -1)
			return true;
	} else
		return false;
};