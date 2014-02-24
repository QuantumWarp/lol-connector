package john_lowther.leagueoflegends.lolconnector.connector;

import john_lowther.leagueoflegends.lolconnector.dataenums.Region;
import john_lowther.leagueoflegends.lolconnector.dataenums.Version;

/**
 * Provides champion requests.
 * Supports BR, EUNE, EUW, LAN, LAS, NA, OCE.
 * @author John Lowther
 */
public class ChampionConnector extends LOLConnector {
	private final String allChampionRequest = "https://prod.api.pvp.net/api/lol/%s/%s/champion";
	
	public ChampionConnector() {
		setSupportedRegions(Region.BRAZIL, Region.EU_NORDIC_AND_EAST, Region.EU_WEST,
				Region.LATIN_AMERICA_NORTH, Region.LATIN_AMERICA_SOUTH,
				Region.NORTH_AMERICA, Region.OCEANIA_AUSTRAILIA, Region.OCEANIA_NEW_ZEALAND);
		setSupportedVersions(Version.ONE_POINT_ONE);
	}
	
	/**
	 * Default champion retrieval
	 * @param region
	 * @param version
	 * @return JSON champions
	 */
	public String getChampions(Region region, String version) {
		String request = String.format(allChampionRequest, region.getCode(), version);
		
		return Connector.getInstance().submitApiRequest(request);
	}
	
	/**
	 * Parametered champion retrieval
	 * @param region
	 * @param version
	 * @param freeToPlay true returns only free to play champions
	 * @return JSON champions
	 */
	public String getChampions(Region region, String version, boolean freeToPlay) {
		String request = String.format(allChampionRequest, region.getCode(), version);
		
		request = addParamToRequest(request, "freeToPlay", freeToPlay);
		
		return Connector.getInstance().submitApiRequest(request);
	}
}
