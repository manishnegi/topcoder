package dataStructures;

import java.util.Stack;

/**
 * Tries are a secret weapon against XOR query problems: 
 * https://threads-iiith.quora.com/Tutorial-on-Trie-and-example-problems
 * 
 * They act like a frequency map, so inserting won't replace anything, only increase the count!
 */

public class TrieHolder {	
	public static class TrieNode {
		private int words;
		private int prefixes;
		private TrieNode[] edges;
		private int depth;
		private TrieNode parent;
		
		public TrieNode(int alphabetSize, TrieNode parent) {
			this.edges = new TrieNode[alphabetSize];
			this.depth = parent == null ? 0 : parent.depth + 1;
			this.parent = parent;
		}
		
		public String toString() {
			return "(" + words + ", " + prefixes + ")";
		}
	}
	
	public static class Trie {
		private TrieNode root;
		private int size;
		private final int alphabetSize;
		
		public Trie(int alphabetSize) {
			this.alphabetSize = alphabetSize;
			this.root = new TrieNode(alphabetSize, null);
		}
		
		/**
		 * Add the word to the Trie. max(word[i]) must be less than alphabetSize!
		 */
		public void addWord(int[] word) {
			addWord(root, word);
		}
		
		public void removeWord(int[] word) {
			if (size > 0 && countWords(word) > 0) {
				removeWord(root, word);
			}
		}
		
		public int countWords(int[] word) {
			return countWords(root, word);
		}
		
		public int countPrefixes(int[] prefix) {
			return countPrefixes(root, prefix);
		}
		
		/**
		 * Find the first point where a given word is unique and return the length. 
		 * For example: this returns the number of keypresses required for an autocompleter to match a word, assuming the word is present.
		 */
		public int findShortestUniqueString(int[] word) {
			return findShortestUniqueString(root, word);
		}
		
		/**
		 * Find the closes match of the word. Only works on binary tries! 
		 * Can be used to find the maximum XOR of two elements in an array in O(nlog(n))
		 */
		public int[] find(int[] word) {
			int n = countWords(word);
			if (n > 0) {
				return word;
			} else {
				int[] bestMatch = word.clone();
				find(root, bestMatch, 0);
				return bestMatch;
			}
		}
		
		private void find(TrieNode vertex, int[] word, int length) {
			if (length < word.length) {
				int best = word[length];
				int alt = (word[length] + 1) % 2;
				if (vertex.edges[best] == null) {
					if (vertex.edges[alt] == null) {
						return;
					}
					word[length] = alt;
					find(vertex.edges[alt], word, length+1);
				} else {
					find(vertex.edges[best], word, length+1);
				}
			}
			return;
		}
		
		/**
		 * Get the lexicographically next entry. (Resumed in-order traversal). Returns null if there is nothing after it.
		 */
		public int[] getNext(int[] word) {
			int[] bestMatch = word.clone();
			getNext(root, word, 0);
			//findClosestString(root, bestMatch, 0);
			return bestMatch;
		}

		private void getNext(TrieNode root, int[] word, int length) {
			//
			// Keep
			//
		}
		
		private void addWord(TrieNode vertex, int[] word) {
			for (int length = 0; length < word.length; length++) {
				vertex.prefixes++;
				int k = word[length];
				if (vertex.edges[k] == null) {
					vertex.edges[k] = new TrieNode(alphabetSize, vertex);
				}
				vertex = vertex.edges[k];
			}
			vertex.words++;
			size++;
		}
		
		private void removeWord(TrieNode vertex, int[] word) {
			for (int length = 0; length < word.length; length++) {
				if (vertex.prefixes > 0 && size > 0) {
					vertex.prefixes--;
				}
				int k = word[length];
				if (vertex.edges[k] == null) {
					vertex.edges[k] = new TrieNode(alphabetSize, vertex);
				}
				vertex = vertex.edges[k];
			}
			if (vertex.words > 0 && size > 0) {
				vertex.words--;
				size--;	
			}
		}

		private int findShortestUniqueString(TrieNode vertex, int[] word) {
			for (int length = 0; length < word.length; length++) {
				int k = word[length];
				if (vertex.edges[k].prefixes + vertex.edges[k].words == 1) {
					return length+1;
				} else {
					vertex = vertex.edges[k];
				}
			}
			return word.length;
		}
		
		/**
		 * Returns the number of words stored in the Trie.
		 */
		public int getSize() {
			return size;
		}
		
		private int countWords(TrieNode vertex, int[] word) {
			for (int length = 0; length < word.length; length++) {
				int k = word[length];
				if (vertex.edges[k] == null) {
					return 0;
				} else {
					vertex = vertex.edges[k];
				}
			}
			return vertex.words;
		}
		
		private int countPrefixes(TrieNode vertex, int[] prefix) {
			for (int length = 0; length < prefix.length; length++) {
				int k = prefix[length];
				if (vertex.edges[k] == null) {
					return 0;
				} else {
					vertex = vertex.edges[k];
				}
			}
			return vertex.prefixes;
		}
		
		public static int[] toTrieValue(char[] str) {
			int[] ret = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				ret[i] = str[i] - 'a';
			}
			return ret;
		}
		
		public static int[] toTrieValue(String str) {
			int[] ret = new int[str.length()];
			char[] s = str.toCharArray();
			for (int i = 0; i < s.length; i++) {
				ret[i] = s[i] - 'a';
			}
			return ret;
		}
		
		public static int[] toTrieValue(long n) {
			int[] ret = new int[64];
			for (int i = ret.length-1; i >= 0; i--) {
				ret[i] = (n & 1) != 0 ? 1 : 0;
				n = n >> 1;
			}
			return ret;
		}
		
		public static int[] toTrieValue(int n) {
			int[] ret = new int[32];
			for (int i = ret.length-1; i >= 0; i--) {
				ret[i] = (n & 1) != 0 ? 1 : 0;
				n = n >> 1;
			}
			return ret;
		}
		
		public static long toLong(int[] n) {
			long ret = 0;
			for (int i = 0; i < n.length; i++) {
				ret |= n[i];
				if (i < n.length-1) {
					ret = ret << 1;
				}
			}
			return ret;
		}
		
		public static int toInt(int[] n) {
			int ret = 0;
			for (int i = 0; i < n.length; i++) {
				ret |= n[i];
				if (i < n.length-1) {
					ret = ret << 1;
				}
			}
			return ret;
		}
	}
}
