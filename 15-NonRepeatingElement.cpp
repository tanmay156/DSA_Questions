/*
Non Repeating Character
Given a string s consisting of lowercase Latin Letters. Return the first non-repeating character in s. If there is no non-repeating character, return '$'.
Note: When you return '$' driver code will output -1.
*/

class Solution {
public:
    char nonRepeatingChar(string s) {
        int freq[26] = {0};
        for (char ch : s) {
            freq[ch - 'a']++;
        }
        for (char ch : s) {
            if (freq[ch - 'a'] == 1) {
                return ch;
            }
        }
        return '$';
    }
};
