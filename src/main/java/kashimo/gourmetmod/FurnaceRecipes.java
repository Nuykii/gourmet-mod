package kashimo.gourmetmod;

import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static kashimo.gourmetmod.GourmetMod.*;

public class FurnaceRecipes implements RecipeEntrypoint {

	public void onRecipesReady() {
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(rawBeef)
			.create("cookSteak", steak.getDefaultStack());

		RecipeBuilder.Furnace(MOD_ID)
			.setInput(rawPork)
			.create("cookPork", roastedPorkchop.getDefaultStack());

		RecipeBuilder.Furnace(MOD_ID)
			.setInput(rawChicken)
			.create("cookChicken", roastedChicken.getDefaultStack());

		RecipeBuilder.Furnace(MOD_ID)
			.setInput(rawMutton)
			.create("cookMutton", roastedLamb.getDefaultStack());

	}

	@Override
	public void initNamespaces() {

	}
}
