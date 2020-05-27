package com.swiderski.app;

import com.swiderski.app.utils.KMPSubstringUtil;
import com.swiderski.app.utils.SubstringUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilsTest {

    private SubstringUtil substringUtil;

    @BeforeEach
    void setUp() {
        substringUtil = new KMPSubstringUtil();
    }

    @Test
    public void isSubstring_shouldReturnFalseBecauseInputIsNull() {
        //given
        String str1 = null;
        String sub1 = "da";
        String str2 = "das";
        String sub2 = null;
        //when
        boolean returned1 = this.substringUtil.isSubstring(str1, sub1);
        boolean returned2 = this.substringUtil.isSubstring(str2, sub2);
        //then
        assertFalse(returned1);
        assertFalse(returned2);
    }

    @Test
    public void isSubstring_shouldReturnFalseBecauseSubstringLengthIsGreater() {
        //given
        String str = "abcdf";
        String sub = "abcdefgh";
        //when
        boolean returned = this.substringUtil.isSubstring(str, sub);
        //then
        assertFalse(returned);
    }

    @Test
    public void isSubstring_shouldReturnTrue() {
        //given
        String str1 = "absabcdsdasdasdasdasdasl";
        String sub1 = "abcd";

        String str2 = "absabcdsdasdasdasdasdasl";
        String sub2 = "absabcdsdasdasdasdasdasl";
        //when
        boolean returned1 = this.substringUtil.isSubstring(str1, sub1);
        boolean returned2 = this.substringUtil.isSubstring(str2, sub2);
        //then
        assertTrue(returned1);
        assertTrue(returned2);

    }

    @Test
    public void isSubstring_shouldReturnTrueWithAsterisk() {
        //given
        String str = "abcdefgf";
        String sub = "c*e";
        //when
        boolean returned = this.substringUtil.isSubstring(str, sub);
        //then
        assertTrue(returned);


    }

    @Test
    public void isSubstring_shouldReturnTrueWithMultipleAsterisk() {
        //given
        String str = "abcdefghij";
        String sub = "*b";
        //when
        boolean returned = this.substringUtil.isSubstring(str, sub);
        //then
        assertTrue(returned);

    }


    @Test
    public void isSubstring_shouldReturnTrueWhenStringWithAsterisk() {
        //given
        String str1 = "abcdefg";
        String sub1 = "c*e*";
        String str2 = "abcdefg";
        String sub2 = "**e**";


        //when
        boolean returned1 = this.substringUtil.isSubstring(str1, sub1);
        boolean returned2 = this.substringUtil.isSubstring(str2, sub2);
        //then
        assertTrue(returned1);
        assertTrue(returned2);

    }

    @Test
    public void isSubstring_shouldReturnTrueSimpleSubstring() {
        //given
        String str = "abcdefg";
        String sub = "efg";
        //when
        boolean returned = this.substringUtil.isSubstring(str, sub);
        //then
        assertTrue(returned);

    }

    @Test
    public void isSubstring_shouldReturnWhenSubstringIsEqualAsterisk() {
        //given
        String str1 = "abcdefg";
        String sub1 = "*";
        String str2 = "abcdefg";
        String sub2 = "****";
        //when
        boolean returned1 = this.substringUtil.isSubstring(str1, sub1);
        boolean returned2 = this.substringUtil.isSubstring(str2, sub2);
        //then
        assertTrue(returned1);
        assertTrue(returned2);

    }

    @Test
    public void isSubstring_shouldReturnWhenStringHaveAsterisk() {
        //given
        String str1 = "a*cdef";
        String sub1 = "a\\*cd";
        String str2 = "a*cde*fgh";
        String sub2 = "de\\*f";
        String str3 = "gasda*bc*defgh";
        String sub3 = "da\\*bc\\*def";
        //when
        boolean returned = this.substringUtil.isSubstring(str1, sub1);
        boolean returned2 = this.substringUtil.isSubstring(str2, sub2);
        boolean returned3 = this.substringUtil.isSubstring(str3, sub3);
        //then
        assertTrue(returned);
        assertTrue(returned2);
        assertTrue(returned3);

    }

    @Test
    public void isSubstring_shouldReturnWhenStringHaveOnlyAsterisk() {
        //given
        String str = "e**";
        String sub = "e\\*\\*";
        //when
        boolean returned = this.substringUtil.isSubstring(str, sub);
        //then
        assertTrue(returned);

    }

    @Test
    public void isSubstring_shouldReturnWhenSubstringEndingWithBackslash() {
        //given
        String str = "ae\\bc";
        String sub = "e\\";
        //when
        boolean returned = this.substringUtil.isSubstring(str, sub);
        //then
        assertTrue(returned);

    }

    @Test
    public void isSubstring_shouldReturnWhenSubstringHaveBackslash() {
        //given
        String str = "ae\\bc";
        String sub = "e\\b";
        //when
        boolean returned = this.substringUtil.isSubstring(str, sub);
        //then
        assertTrue(returned);
    }

    @Test
    public void isSubstring_shouldReturnTrueWhenSubstringHaveBackslashAndAsterisk() {
        //given
        String str = "aedasd*bc";
        String sub = "e*\\*b";
        //when
        boolean returned = this.substringUtil.isSubstring(str, sub);
        //then
        assertTrue(returned);
    }

    @Test
    public void isSubstring_shouldReturnTrueWhenSubstringHaveOnlyBackslash() {
        //given
        String str = "\\\\\\";
        String sub = "\\\\";
        //when
        boolean returned = this.substringUtil.isSubstring(str, sub);
        //then
        assertTrue(returned);
    }

    @Test
    public void isSubstring_shouldReturnFalse() {
        //given
        String str1 = "asda";
        String sub1 = "ag";

        String str2 = "asda";
        String sub2 = "a*g";

        String str3 = "ada";
        String sub3 = "a\\*a";

        String str4 = "ada";
        String sub4 = "a*\\*a";


        //when
        boolean returned1 = this.substringUtil.isSubstring(str1, sub1);
        boolean returned2 = this.substringUtil.isSubstring(str2, sub2);
        boolean returned3 = this.substringUtil.isSubstring(str3, sub3);
        boolean returned4 = this.substringUtil.isSubstring(str4, sub4);
        //then
        assertFalse(returned1);
        assertFalse(returned2);
        assertFalse(returned3);
        assertFalse(returned4);
    }
}
