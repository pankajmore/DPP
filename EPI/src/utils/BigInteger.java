package utils;

/** Created by Pankaj on 12/22/15. */
public class BigInteger {
  private final boolean negative;
  private final String _bigInt;

  public BigInteger(String bigInt) {
    negative = bigInt.charAt(0) == '-';
    _bigInt = negative ? bigInt.substring(1) : bigInt;
  }

  private BigInteger(boolean negative, String bigInt) {
    this.negative = negative;
    this._bigInt = bigInt;
  }

  public String toString() {
    return (negative ? "-" : "") + _bigInt;
  }

  public boolean equals(Object o) {
    if (o == null) return false;
    if (!(o instanceof BigInteger)) return false;
    BigInteger other = (BigInteger) o;
    return this.negative == other.negative && this._bigInt.equals(other._bigInt);
  }

  public BigInteger multiply(BigInteger o) {
    boolean negative = this.negative ^ o.negative;
    StringBuffer B = new StringBuffer(o._bigInt).reverse();
    BigInteger result = new BigInteger("0");
    for (int i = 0; i < B.length(); i++) {
      result = result.add(this.multiply(B.charAt(i) - '0').shiftLeft(i));
    }
    return new BigInteger(negative, result.stripLeadingZeros().toString());
  }

  private BigInteger stripLeadingZeros() {
    int i;
    for (i = 0; i < _bigInt.length() - 1; i++) {
      if (_bigInt.charAt(i) != '0') break;
    }
    return new BigInteger(negative ? "-" : "" + _bigInt.substring(i));
  }

  private BigInteger shiftLeft(int x) {
    StringBuilder sb = new StringBuilder();
    while (x-- > 0) sb.append(0);
    return new BigInteger(negative, this._bigInt.concat(sb.toString()));
  }

  public BigInteger multiply(int x) {
    if (x == 0) return new BigInteger("0");
    boolean negative = this.negative ^ (x < 0);
    x = Math.abs(x);
    final StringBuilder sb = new StringBuilder();
    StringBuffer A = new StringBuffer(_bigInt).reverse();
    int carry = 0;
    for (int i = 0; i < A.length(); i++) {
      int d = (A.charAt(i) - '0') * x + carry;
      carry = d / 10;
      sb.append(d % 10);
    }
    if (carry > 0) sb.append(carry);
    return new BigInteger(negative, sb.reverse().toString());
  }

  /**
   * Time: O((nlog(x))^2) Space: O(nlog(x))
   *
   * @param n the exponent
   * @return this^n
   */
  public BigInteger pow(int n) {
    BigInteger x = this;
    BigInteger res = new BigInteger("1");
    if (n < 0) throw new IllegalArgumentException("Negative exponent: " + n);
    if (n == 0) return res;
    while (n > 1) {
      if ((n & 1) == 1) res = res.multiply(x);
      x = x.multiply(x);
      n >>>= 1;
    }
    return res.multiply(x);
  }

  public BigInteger add(BigInteger o) {
    boolean negative = this.negative || o.negative;
    final StringBuilder sb = new StringBuilder();
    StringBuffer A = new StringBuffer(_bigInt).reverse();
    StringBuffer B = new StringBuffer(o._bigInt).reverse();
    int m = A.length(), n = B.length();
    int i, carry = 0;
    for (i = 0; i < Math.max(m, n); i++) {
      int currentSum = (i < m ? A.charAt(i) - '0' : 0) + (i < n ? B.charAt(i) - '0' : 0) + carry;
      carry = currentSum / 10;
      currentSum = currentSum % 10;
      sb.append(currentSum);
    }
    if (carry > 0) sb.append(carry);
    return new BigInteger(negative, sb.reverse().toString());
  }
}
