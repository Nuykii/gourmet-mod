package kashimo.gourmetmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.item.ItemFood;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;

public class GourmetMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
    public static String MOD_ID = "gourmetmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	/* How the mod is coded:
	*
	* you first have to declare the itemfoods in the class itself as seen below.
	* then, you must create a public function (I called it InitializeItems) where you define what the item is and how it looks like using the ItemBuilder
	* (ItemHelper is obsolete)
	*
	* then, in your java class for recipes, you just use said declared itemfoods as you normally would for all your recipes.
	* my guess is that they changed it because it makes code look more organized
	*
	* */

	public static ItemFood rawBeef;
	public static ItemFood rawPork;
	public static ItemFood rawChicken;
	public static ItemFood rawMutton;

	public static ItemFood steak;
	public static ItemFood roastedPorkchop;
	public static ItemFood roastedLamb;
	public static ItemFood roastedChicken;


	static{ //this just uses UtilIdRegistrar for Ids
		Properties prop = new Properties();
		prop.setProperty("startingBlockId","10000");
		prop.setProperty("startingItemId","19000");
		ConfigHandler config = new ConfigHandler(MOD_ID,prop);
		config.updateConfig();
		UtilIdRegistrar.initIds(config.getInt("startingBlockId"), config.getInt("startingItemId"));
	}

	public void InitializeItems() {
		rawBeef = new ItemBuilder(MOD_ID)
			.setIcon(MOD_ID + ":item/rawBeef")
			.build(new ItemFood("food.rawBeef", UtilIdRegistrar.nextIdItem(), 2, 4, true, 4));

		rawPork = new ItemBuilder(MOD_ID)
			.setIcon(MOD_ID + ":item/rawPork")
			.build(new ItemFood("food.rawPork", UtilIdRegistrar.nextIdItem(), 2, 4, true, 4));

		rawChicken = new ItemBuilder(MOD_ID)
			.setIcon(MOD_ID + ":item/rawChicken")
			.build(new ItemFood("food.rawChicken", UtilIdRegistrar.nextIdItem(), 1, 6, true, 4));

		rawMutton = new ItemBuilder(MOD_ID)
			.setIcon(MOD_ID + ":item/rawMutton")
			.build(new ItemFood("food.rawMutton", UtilIdRegistrar.nextIdItem(), 1, 7, true, 4));

		steak = new ItemBuilder(MOD_ID)
			.setIcon(MOD_ID + ":item/steak")
			.build(new ItemFood("food.steak", UtilIdRegistrar.nextIdItem(), 6, 5, true, 4));

		roastedPorkchop = new ItemBuilder(MOD_ID)
			.setIcon(MOD_ID + ":item/roastedPorkchop")
			.build(new ItemFood("food.roastedPorkchop", UtilIdRegistrar.nextIdItem(), 5, 4, true, 4));

		roastedLamb = new ItemBuilder(MOD_ID)
			.setIcon(MOD_ID + ":item/roastedLamb")
			.build(new ItemFood("food.roastedLamb", UtilIdRegistrar.nextIdItem(), 4, 2, true, 4));

		roastedChicken = new ItemBuilder(MOD_ID)
			.setIcon(MOD_ID + ":item/roastedChicken")
			.build(new ItemFood("food.roastedChicken", UtilIdRegistrar.nextIdItem(), 6, 7, true, 4));

	}


    @Override
    public void onInitialize() {
        LOGGER.info("Gourmet mod has been initialized. Bon appetit.");
    }

	@Override
	public void beforeGameStart() {
		InitializeItems();
	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {

	}

	@Override
	public void initNamespaces() {

	}
}
