package top.alittlebot.thinking.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.CodModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import top.alittlebot.thinking.entity.Zako;

@OnlyIn(Dist.CLIENT)
public class ZakoRenderer extends MobRenderer<Zako, CodModel<Zako>> {
    private static final ResourceLocation COD_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/fish/cod.png");

    public ZakoRenderer(EntityRendererProvider.Context p_173954_) {
        super(p_173954_, new CodModel<>(p_173954_.bakeLayer(ModelLayers.COD)), 0.3F);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public @NotNull ResourceLocation getTextureLocation(@NotNull Zako entity) {
        return COD_LOCATION;
    }

    protected void setupRotations(@NotNull Zako entity, @NotNull PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
        super.setupRotations(entity, poseStack, bob, yBodyRot, partialTick, scale);
        float f = 4.3F * Mth.sin(0.6F * bob);
        poseStack.mulPose(Axis.YP.rotationDegrees(f));
        if (!entity.isInWater()) {
            poseStack.translate(0.1F, 0.1F, -0.1F);
            poseStack.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }
    }
}
