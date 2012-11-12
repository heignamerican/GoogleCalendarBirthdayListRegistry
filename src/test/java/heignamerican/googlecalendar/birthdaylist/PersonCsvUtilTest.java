package heignamerican.googlecalendar.birthdaylist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PersonCsvUtilTest extends PersonCsvUtil {
	private File mFile;

	@Before
	public void setUp() {
		mFile = new File(GoogleApp.class.getResource("source.csv").getPath());
	}

	@Test
	public void testGetPersonFrom() throws IOException {
		List<Person> tPersonList = PersonCsvUtil.getPersonsFrom(mFile);
		assertThat(tPersonList, is(getExpected()));
	}

	private static List<Person> getExpected() {
		//@formatter:off
		return Arrays.asList(
			 new Person("野乃原結","2012/01/04")
			,new Person("宇佐美玲","2012/01/04")
			,new Person("青砥正則","2012/01/15")
			,new Person("小津千歳","2012/01/17")
			,new Person("モーリッツ・ザベル・フランツ","2012/01/20")
			,new Person("美術部部長","2012/01/22")
			,new Person("御園千莉","2012/01/23")
			,new Person("エステル・フリージア","2012/01/31")
			,new Person("エリス・フローラリア","2012/02/05")
			,new Person("遠山翠","2012/02/10")
			,new Person("東儀白","2012/02/19")
			,new Person("橘ちひろ","2012/02/26")
			,new Person("穂積さやか","2012/03/06")
			,new Person("ライオネス・テオ・アーシュライト","2012/03/10")
			,new Person("ユースティア・アストレア","2012/03/14")
			,new Person("秋山文緒","2012/03/21")
			,new Person("白崎つぐみ","2012/03/29")
			,new Person("羽根井優希","2012/03/31")
			,new Person("悠木かなで","2012/04/02")
			,new Person("ミリィ","2012/04/07")
			,new Person("東儀征一郎","2012/04/09")
			,new Person("ラピス・メルクリウス・フレイア","2012/04/17")
			,new Person("リースリット・ノエル","2012/04/19")
			,new Person("フィアッカ・マルグリット","2012/04/19")
			,new Person("芹沢水結","2012/04/23")
			,new Person("筧京太郎","2012/04/28")
			,new Person("天池志津子","2012/05/03")
			,new Person("天ヶ崎美琴","2012/05/15")
			,new Person("鷹見沢菜月","2012/05/23")
			,new Person("千堂瑛里華","2012/06/07")
			,new Person("シンシア・マルグリット","2012/06/12")
			,new Person("鈴木佳奈","2012/06/16")
			,new Person("ディアナ・ペシュカ・ホリー・エリンギ","2012/06/25")
			,new Person("レティシア・ラ・ミュウ・シンフォニア","2012/07/05")
			,new Person("千堂伽耶","2012/07/12")
			,new Person("渋垣茉理","2012/07/17")
			,new Person("川中島里美","2012/07/23")
			,new Person("朝霧麻衣","2012/08/03")
			,new Person("千堂伊織","2012/08/07")
			,new Person("望月真帆","2012/08/08")
			,new Person("リシア・ド・ノーヴァス・ユーリィ","2012/08/16")
			,new Person("シルフィ・クラウド","2012/08/22")
			,new Person("鷹見沢仁","2012/09/04")
			,new Person("レイチェル・ハーベスト","2012/09/09")
			,new Person("藤枝保奈美","2012/09/11")
			,new Person("嬉野紗弓実","2012/09/19")
			,new Person("八幡平司","2012/09/20")
			,new Person("フィーナ・ファム・アーシュライト","2012/09/29")
			,new Person("悠木陽菜","2012/10/04")
			,new Person("諏訪奈都子","2012/10/16")
			,new Person("聖女イレーヌ","2012/10/20")
			,new Person("鷹見沢左門","2012/10/29")
			,new Person("桜庭玉藻","2012/11/01")
			,new Person("フィオネ・シルヴァリア","2012/11/09")
			,new Person("仁科恭子","2012/11/15")
			,new Person("紅瀬桐葉","2012/11/21")
			,new Person("カレン・クラヴィウス","2012/11/30")
			,new Person("エレノア・フォートワース","2012/12/01")
			,new Person("渋垣英理","2012/12/02")
			,new Person("吉野佳澄","2012/12/05")
			,new Person("朝霧達哉","2012/12/12")
			,new Person("ミア・クレメンティス","2012/12/22")
			,new Person("高峰一景","2012/12/25")
			,new Person("広瀬柚香","2012/12/26")
			,new Person("小太刀凪","2012/12/31")
		);
		//@formatter:on
	}
}
