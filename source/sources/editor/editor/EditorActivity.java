package editor.editor;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.livinglifetechway.quickpermissions_kotlin.PermissionsManagerKt;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions;
import com.memes.commons.activity.ContractLauncher;
import com.memes.commons.media.MediaContent;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NEditorActivityBinding;
import editor.common.alertmessagebottomsheet.AlertMessageBottomSheet;
import editor.common.alertmessagebottomsheet.AlertMessageConfig;
import editor.common.choicesbottomsheet.Choice;
import editor.common.choicesbottomsheet.ChoicesBottomSheet;
import editor.common.choicesbottomsheet.categories.CropChoice;
import editor.common.commonslider.CommonSliderInput;
import editor.common.commonslider.CommonSliderViewModel;
import editor.common.nudge.NudgeViewModel;
import editor.core.NEditorPlanAwareActivity;
import editor.custom.liveevent.LiveEventObserver;
import editor.editor.dashboard.drafts.EditorDraftsViewModel;
import editor.editor.editorframehost.frame.EditorFrame;
import editor.editor.editorframehost.frame.EditorFrameCallback;
import editor.editor.equipment.core.CoreConfig;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.frame.FrameEntity;
import editor.editor.equipment.frame.FrameStyle;
import editor.editor.equipment.media.MediaEntity;
import editor.editor.equipment.media.MediaStyle;
import editor.editor.equipment.media.content.CropSpec;
import editor.editor.equipment.media.content.FilterSpec;
import editor.editor.equipment.property.FrameProperty;
import editor.editor.equipment.property.MediaProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.editor.equipment.text.TextEntity;
import editor.editor.equipment.text.TextStyle;
import editor.editor.equipment.trigger.NicoTrigger;
import editor.editor.plan.EditorPlan;
import editor.editor.plan.EditorPlanRequirement;
import editor.mediaselection.MediaSelectionActivityContract;
import editor.mediaselection.MediaSelectionConfig;
import editor.optionsui.addcontent.AddContentChoice;
import editor.optionsui.addcontent.contentpicker.ContentPickerActivityContract;
import editor.optionsui.addcontent.contentpicker.ContentPickerTarget;
import editor.optionsui.addcontent.text.AddTextActivityContract;
import editor.optionsui.frame.frameresize.FrameSize;
import editor.optionsui.frame.tabs.FrameTabsViewModel;
import editor.optionsui.layout.tabs.LayoutTabsViewModel;
import editor.optionsui.layout.templates.Template;
import editor.optionsui.layout.wireframes.WireframesViewModel;
import editor.optionsui.media.tabs.MediaOptionViewModel;
import editor.optionsui.optiontabs.BottomOptionTab;
import editor.optionsui.optiontabs.BottomOptionTabsAdapter;
import editor.optionsui.text.tabs.TextTabsViewModel;
import editor.optionsui.text.textadjust.TextAdjustViewModel;
import editor.optionsui.text.textspacing.TextSpacingViewModel;
import editor.optionsui.watermark.PhotoWatermarkSource;
import editor.optionsui.watermark.home.WatermarkViewModel;
import editor.optionsui.watermark.savedwatermarks.SavedWatermarksViewModel;
import editor.optionsui.watermark.savepreview.SaveWatermarkBottomSheet;
import editor.tools.crop.CropActivityContract;
import editor.tools.crop.CropBounds;
import editor.tools.filters.FilterActivityContract;
import editor.tools.filters.MediaFilter;
import editor.tools.filters.conflation.FilterRequest;
import editor.tools.filters.conflation.FilterResult;
import editor.tools.signature.SignatureActivityContract;
import editor.transporter.FragmentManagerUtil;
import editor.util.ExtKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.ClassUtils;
import timber.log.Timber;
import tools.activityproxy.ActivityExtra;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000À\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0002²\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\u0005H\u0002J$\u0010h\u001a\u00020f2\u001a\u0010i\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00110jj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011`kH\u0002J\u0010\u0010l\u001a\u00020f2\u0006\u0010m\u001a\u00020nH\u0002J\u0010\u0010o\u001a\u00020f2\u0006\u0010p\u001a\u00020qH\u0002J\u0010\u0010r\u001a\u00020f2\u0006\u0010s\u001a\u00020\u0005H\u0002J\b\u0010t\u001a\u00020fH\u0002J\u001b\u0010u\u001a\u00020v2\b\b\u0002\u0010w\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010xJ\b\u0010y\u001a\u00020zH\u0002J\u0010\u0010{\u001a\u00020f2\u0006\u0010|\u001a\u00020}H\u0002J\u0010\u0010~\u001a\u00020f2\u0006\u0010|\u001a\u00020}H\u0002J\b\u0010\u001a\u00020fH\u0002J\t\u0010\u0001\u001a\u00020fH\u0002J\t\u0010\u0001\u001a\u00020fH\u0016J\u0013\u0010\u0001\u001a\u00020f2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0015\u0010\u0001\u001a\u00020f2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J\t\u0010\u0001\u001a\u00020fH\u0002J\t\u0010\u0001\u001a\u00020fH\u0014J\u0013\u0010\u0001\u001a\u00020f2\b\u0010\u0001\u001a\u00030\u0001H\u0014J\t\u0010\u0001\u001a\u00020fH\u0014J\u0013\u0010\u0001\u001a\u00020f2\b\u0010\u0001\u001a\u00030\u0001H\u0014J\u0012\u0010\u0001\u001a\u00020f2\u0007\u0010\u0001\u001a\u00020\u0012H\u0002J*\u0010\u0001\u001a\u00020f2\u0007\u0010\u0001\u001a\u00020\u000f2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00052\t\b\u0002\u0010\u0001\u001a\u00020\u0012H\u0002J\u001c\u0010\u0001\u001a\u00020f2\u0007\u0010\u0001\u001a\u00020\u00052\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001b\u0010\u0001\u001a\u00020f2\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0014H\u0002J,\u0010\u0001\u001a\u00020f2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00052\t\b\u0002\u0010\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u0001\u001a\u00020\u0012H\u0002J&\u0010\u0001\u001a\u00020f2\u0007\u0010\u0001\u001a\u00020\u00052\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020fH\u0002J\"\u0010\u0001\u001a\u00020f2\t\b\u0002\u0010\u0001\u001a\u00020\u00052\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u001c\u0010 \u0001\u001a\u00020f2\u0007\u0010\u0001\u001a\u00020\u00052\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0002J\u001c\u0010£\u0001\u001a\u00020f2\u0007\u0010\u0001\u001a\u00020\u00052\b\u0010¤\u0001\u001a\u00030¢\u0001H\u0002J\u001c\u0010¥\u0001\u001a\u00020f2\u0007\u0010\u0001\u001a\u00020\u00052\b\u0010¦\u0001\u001a\u00030¢\u0001H\u0002J\u0016\u0010§\u0001\u001a\u00020f2\u000b\b\u0002\u0010¨\u0001\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010©\u0001\u001a\u00020f2\u0007\u0010\u0001\u001a\u00020\u00052\b\u0010ª\u0001\u001a\u00030«\u0001H\u0002J\t\u0010¬\u0001\u001a\u00020fH\u0002J\u001f\u0010­\u0001\u001a\u00020f2\b\u0010®\u0001\u001a\u00030¯\u00012\n\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR(\u0010\u000e\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00120\u00100\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b,\u0010\r\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b1\u0010\r\u001a\u0004\b/\u00100R\u001b\u00102\u001a\u0002038BX\u0002¢\u0006\f\n\u0004\b6\u0010\r\u001a\u0004\b4\u00105R\"\u00107\u001a\u0016\u0012\u0004\u0012\u000208\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001090\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0002¢\u0006\f\n\u0004\b>\u0010\r\u001a\u0004\b<\u0010=R\u001b\u0010?\u001a\u00020@8BX\u0002¢\u0006\f\n\u0004\bC\u0010\r\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u00020E8BX\u0002¢\u0006\f\n\u0004\bH\u0010\r\u001a\u0004\bF\u0010GR\u000e\u0010I\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010J\u001a\u0010\u0012\u0004\u0012\u00020K\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010L\u001a\u00020M8BX\u0002¢\u0006\f\n\u0004\bP\u0010\r\u001a\u0004\bN\u0010OR\u001b\u0010Q\u001a\u00020R8BX\u0002¢\u0006\f\n\u0004\bU\u0010\r\u001a\u0004\bS\u0010TR\u001b\u0010V\u001a\u00020W8BX\u0002¢\u0006\f\n\u0004\bZ\u0010\r\u001a\u0004\bX\u0010YR\u001b\u0010[\u001a\u00020\\8BX\u0002¢\u0006\f\n\u0004\b_\u0010\r\u001a\u0004\b]\u0010^R\u001b\u0010`\u001a\u00020a8BX\u0002¢\u0006\f\n\u0004\bd\u0010\r\u001a\u0004\bb\u0010c\u0002\u0004\n\u0002\b\u0019¨\u0006³\u0001"}, mo26107d2 = {"Leditor/editor/EditorActivity;", "Leditor/core/NEditorPlanAwareActivity;", "()V", "addTextContractLauncher", "Lcom/memes/commons/activity/ContractLauncher;", "", "binding", "Lcom/memes/editor/databinding/NEditorActivityBinding;", "commonSliderViewModel", "Leditor/common/commonslider/CommonSliderViewModel;", "getCommonSliderViewModel", "()Leditor/common/commonslider/CommonSliderViewModel;", "commonSliderViewModel$delegate", "Lkotlin/Lazy;", "contentPickerContractLauncher", "Leditor/optionsui/addcontent/contentpicker/ContentPickerTarget;", "Lkotlin/Pair;", "Lcom/memes/commons/media/MediaContent;", "", "cropContractLauncher", "Leditor/editor/equipment/media/content/CropSpec;", "draftsViewModel", "Leditor/editor/dashboard/drafts/EditorDraftsViewModel;", "getDraftsViewModel", "()Leditor/editor/dashboard/drafts/EditorDraftsViewModel;", "draftsViewModel$delegate", "exitAfterDraftIsSaved", "filtersContractLauncher", "Leditor/tools/filters/conflation/FilterRequest;", "Leditor/tools/filters/conflation/FilterResult;", "fragmentManagerUtil", "Leditor/transporter/FragmentManagerUtil;", "getFragmentManagerUtil", "()Leditor/transporter/FragmentManagerUtil;", "fragmentManagerUtil$delegate", "frameTabsViewModel", "Leditor/optionsui/frame/tabs/FrameTabsViewModel;", "getFrameTabsViewModel", "()Leditor/optionsui/frame/tabs/FrameTabsViewModel;", "frameTabsViewModel$delegate", "generatorViewModel", "Leditor/editor/EditorViewModel;", "getGeneratorViewModel", "()Leditor/editor/EditorViewModel;", "generatorViewModel$delegate", "layoutTabsViewModel", "Leditor/optionsui/layout/tabs/LayoutTabsViewModel;", "getLayoutTabsViewModel", "()Leditor/optionsui/layout/tabs/LayoutTabsViewModel;", "layoutTabsViewModel$delegate", "mediaOptionViewModel", "Leditor/optionsui/media/tabs/MediaOptionViewModel;", "getMediaOptionViewModel", "()Leditor/optionsui/media/tabs/MediaOptionViewModel;", "mediaOptionViewModel$delegate", "mediaSelectionContractLauncher", "Leditor/mediaselection/MediaSelectionConfig;", "", "nudgeViewModel", "Leditor/common/nudge/NudgeViewModel;", "getNudgeViewModel", "()Leditor/common/nudge/NudgeViewModel;", "nudgeViewModel$delegate", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "getOutputTargetGenerator", "()Lcom/memes/commons/output/OutputTargetGenerator;", "outputTargetGenerator$delegate", "savedWatermarksViewModel", "Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksViewModel;", "getSavedWatermarksViewModel", "()Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksViewModel;", "savedWatermarksViewModel$delegate", "sessionId", "signatureContractLauncher", "Ljava/io/File;", "textAdjustViewModel", "Leditor/optionsui/text/textadjust/TextAdjustViewModel;", "getTextAdjustViewModel", "()Leditor/optionsui/text/textadjust/TextAdjustViewModel;", "textAdjustViewModel$delegate", "textSpacingViewModel", "Leditor/optionsui/text/textspacing/TextSpacingViewModel;", "getTextSpacingViewModel", "()Leditor/optionsui/text/textspacing/TextSpacingViewModel;", "textSpacingViewModel$delegate", "textTabsViewModel", "Leditor/optionsui/text/tabs/TextTabsViewModel;", "getTextTabsViewModel", "()Leditor/optionsui/text/tabs/TextTabsViewModel;", "textTabsViewModel$delegate", "watermarkViewModel", "Leditor/optionsui/watermark/home/WatermarkViewModel;", "getWatermarkViewModel", "()Leditor/optionsui/watermark/home/WatermarkViewModel;", "watermarkViewModel$delegate", "wireframesViewModel", "Leditor/optionsui/layout/wireframes/WireframesViewModel;", "getWireframesViewModel", "()Leditor/optionsui/layout/wireframes/WireframesViewModel;", "wireframesViewModel$delegate", "applyDraft", "", "draftId", "applyExtraMediaContents", "contents", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "applyFrameSize", "frameSize", "Leditor/optionsui/frame/frameresize/FrameSize;", "applyTemplate", "template", "Leditor/optionsui/layout/templates/Template;", "applyWireframe", "wireframeId", "attachObservers", "createExportCommandSource", "Leditor/editor/export/command/ExportCommandSource;", "useOptimizationDelay", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFrame", "Leditor/editor/editorframehost/frame/EditorFrame;", "handleMediaTrigger", "trigger", "Leditor/editor/equipment/trigger/NicoTrigger;", "handleTextTrigger", "initData", "initUi", "onBackPressed", "onBottomOptionTabTapped", "optionTab", "Leditor/optionsui/optiontabs/BottomOptionTab;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onExportButtonTapped", "onPause", "onRestoreInstanceState", "bundle", "onResume", "onSaveInstanceState", "outState", "saveDraft", "exitAfterwards", "showContentPicker", "target", "token", "isWatermark", "showCropTool", "style", "Leditor/editor/equipment/media/MediaStyle;", "cropSpec", "showEditTextPage", "text", "showFilters", "filterTab", "Leditor/tools/filters/conflation/FilterRequest$FilterTab;", "showFrameTabsPage", "showMediaSelectionPage", "showOpacitySlider", "initialOpacity", "", "showRotationSlider", "initialRotation", "showScaleSlider", "initialScale", "showSignatureWatermarkTool", "existingToken", "showSingleSlider", "input", "Leditor/common/commonslider/CommonSliderInput;", "showWatermarkPage", "updateEditorPlan", "plan", "Leditor/editor/plan/EditorPlan;", "requirement", "Leditor/editor/plan/EditorPlanRequirement;", "EditorFrameCallbackWrapper", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
public abstract class EditorActivity extends NEditorPlanAwareActivity {
    private final ContractLauncher<String, String> addTextContractLauncher = new ContractLauncher<>(new AddTextActivityContract());
    /* access modifiers changed from: private */
    public NEditorActivityBinding binding;
    private final Lazy commonSliderViewModel$delegate = LazyKt.lazy(new EditorActivity$commonSliderViewModel$2(this));
    private final ContractLauncher<ContentPickerTarget, Pair<MediaContent, Boolean>> contentPickerContractLauncher = new ContractLauncher<>(new ContentPickerActivityContract());
    private final ContractLauncher<CropSpec, CropSpec> cropContractLauncher = new ContractLauncher<>(new CropActivityContract());
    private final Lazy draftsViewModel$delegate = LazyKt.lazy(new EditorActivity$draftsViewModel$2(this));
    /* access modifiers changed from: private */
    public boolean exitAfterDraftIsSaved;
    private final ContractLauncher<FilterRequest, FilterResult> filtersContractLauncher = new ContractLauncher<>(new FilterActivityContract());
    private final Lazy fragmentManagerUtil$delegate = LazyKt.lazy(new EditorActivity$fragmentManagerUtil$2(this));
    private final Lazy frameTabsViewModel$delegate = LazyKt.lazy(new EditorActivity$frameTabsViewModel$2(this));
    private final Lazy generatorViewModel$delegate = LazyKt.lazy(new EditorActivity$generatorViewModel$2(this));
    private final Lazy layoutTabsViewModel$delegate = LazyKt.lazy(new EditorActivity$layoutTabsViewModel$2(this));
    private final Lazy mediaOptionViewModel$delegate = LazyKt.lazy(new EditorActivity$mediaOptionViewModel$2(this));
    private final ContractLauncher<MediaSelectionConfig, List<MediaContent>> mediaSelectionContractLauncher = new ContractLauncher<>(new MediaSelectionActivityContract());
    private final Lazy nudgeViewModel$delegate = LazyKt.lazy(new EditorActivity$nudgeViewModel$2(this));
    private final Lazy outputTargetGenerator$delegate = LazyKt.lazy(new EditorActivity$outputTargetGenerator$2(this));
    private final Lazy savedWatermarksViewModel$delegate = LazyKt.lazy(new EditorActivity$savedWatermarksViewModel$2(this));
    /* access modifiers changed from: private */
    public final String sessionId = EditorSession.INSTANCE.create();
    private final ContractLauncher<File, MediaContent> signatureContractLauncher = new ContractLauncher<>(new SignatureActivityContract());
    private final Lazy textAdjustViewModel$delegate = LazyKt.lazy(new EditorActivity$textAdjustViewModel$2(this));
    private final Lazy textSpacingViewModel$delegate = LazyKt.lazy(new EditorActivity$textSpacingViewModel$2(this));
    private final Lazy textTabsViewModel$delegate = LazyKt.lazy(new EditorActivity$textTabsViewModel$2(this));
    private final Lazy watermarkViewModel$delegate = LazyKt.lazy(new EditorActivity$watermarkViewModel$2(this));
    private final Lazy wireframesViewModel$delegate = LazyKt.lazy(new EditorActivity$wireframesViewModel$2(this));

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[BottomOptionTab.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[BottomOptionTab.ADD.ordinal()] = 1;
            iArr[BottomOptionTab.LAYOUT.ordinal()] = 2;
            iArr[BottomOptionTab.RESIZE.ordinal()] = 3;
            iArr[BottomOptionTab.WATERMARK.ordinal()] = 4;
            int[] iArr2 = new int[PhotoWatermarkSource.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[PhotoWatermarkSource.RAW.ordinal()] = 1;
            iArr2[PhotoWatermarkSource.SIGNATURE.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: private */
    public final CommonSliderViewModel getCommonSliderViewModel() {
        return (CommonSliderViewModel) this.commonSliderViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EditorDraftsViewModel getDraftsViewModel() {
        return (EditorDraftsViewModel) this.draftsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FragmentManagerUtil getFragmentManagerUtil() {
        return (FragmentManagerUtil) this.fragmentManagerUtil$delegate.getValue();
    }

    private final FrameTabsViewModel getFrameTabsViewModel() {
        return (FrameTabsViewModel) this.frameTabsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EditorViewModel getGeneratorViewModel() {
        return (EditorViewModel) this.generatorViewModel$delegate.getValue();
    }

    private final LayoutTabsViewModel getLayoutTabsViewModel() {
        return (LayoutTabsViewModel) this.layoutTabsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MediaOptionViewModel getMediaOptionViewModel() {
        return (MediaOptionViewModel) this.mediaOptionViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final NudgeViewModel getNudgeViewModel() {
        return (NudgeViewModel) this.nudgeViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final OutputTargetGenerator getOutputTargetGenerator() {
        return (OutputTargetGenerator) this.outputTargetGenerator$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SavedWatermarksViewModel getSavedWatermarksViewModel() {
        return (SavedWatermarksViewModel) this.savedWatermarksViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TextAdjustViewModel getTextAdjustViewModel() {
        return (TextAdjustViewModel) this.textAdjustViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TextSpacingViewModel getTextSpacingViewModel() {
        return (TextSpacingViewModel) this.textSpacingViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TextTabsViewModel getTextTabsViewModel() {
        return (TextTabsViewModel) this.textTabsViewModel$delegate.getValue();
    }

    private final WatermarkViewModel getWatermarkViewModel() {
        return (WatermarkViewModel) this.watermarkViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final WireframesViewModel getWireframesViewModel() {
        return (WireframesViewModel) this.wireframesViewModel$delegate.getValue();
    }

    public static final /* synthetic */ NEditorActivityBinding access$getBinding$p(EditorActivity editorActivity) {
        NEditorActivityBinding nEditorActivityBinding = editorActivity.binding;
        if (nEditorActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nEditorActivityBinding;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CoreConfig coreConfig = CoreConfig.INSTANCE;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        coreConfig.initResources(resources);
        NEditorActivityBinding inflate = NEditorActivityBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "NEditorActivityBinding.inflate(layoutInflater)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        setContentView((View) inflate.root);
        initUi();
        attachObservers();
        QuickPermissionsOptions quickPermissionsOptions = new QuickPermissionsOptions(false, (String) null, false, (String) null, (Function1) null, (Function1) null, (Function1) null, 127, (DefaultConstructorMarker) null);
        quickPermissionsOptions.setPermissionsDeniedMethod(new EditorActivity$onCreate$$inlined$apply$lambda$1(this));
        quickPermissionsOptions.setPermanentDeniedMethod(quickPermissionsOptions.getPermissionsDeniedMethod());
        Unit unit = Unit.INSTANCE;
        PermissionsManagerKt.runWithPermissions((Context) this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, quickPermissionsOptions, (Function0<Unit>) new EditorActivity$onCreate$2(this));
    }

    private final void initUi() {
        NEditorActivityBinding nEditorActivityBinding = this.binding;
        if (nEditorActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = nEditorActivityBinding.root;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.root");
        ExtKt.enableChangingTransitionType(linearLayout);
        NEditorActivityBinding nEditorActivityBinding2 = this.binding;
        if (nEditorActivityBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditorFrame editorFrame = nEditorActivityBinding2.frame;
        Intrinsics.checkNotNullExpressionValue(editorFrame, "binding.frame");
        ExtKt.enableChangingTransitionType(editorFrame);
        NEditorActivityBinding nEditorActivityBinding3 = this.binding;
        if (nEditorActivityBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = nEditorActivityBinding3.frameContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.frameContainer");
        ExtKt.enableChangingTransitionType(frameLayout);
        getSupportFragmentManager().addOnBackStackChangedListener(new EditorActivity$initUi$1(this));
        NEditorActivityBinding nEditorActivityBinding4 = this.binding;
        if (nEditorActivityBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nEditorActivityBinding4.homeImageView.setOnClickListener(new EditorActivity$initUi$2(this));
        NEditorActivityBinding nEditorActivityBinding5 = this.binding;
        if (nEditorActivityBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nEditorActivityBinding5.exportImageView.setOnClickListener(new EditorActivity$initUi$3(this));
        NEditorActivityBinding nEditorActivityBinding6 = this.binding;
        if (nEditorActivityBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nEditorActivityBinding6.officialWatermarkView.setOnClickListener(new EditorActivity$initUi$4(this));
        NEditorActivityBinding nEditorActivityBinding7 = this.binding;
        if (nEditorActivityBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nEditorActivityBinding7.hiddenEntitiesIndicatorView.setOnClickListener(new EditorActivity$initUi$5(this));
        NEditorActivityBinding nEditorActivityBinding8 = this.binding;
        if (nEditorActivityBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nEditorActivityBinding8.frame.setTouchCallback(new EditorFrameCallbackWrapper());
        Context context = this;
        BottomOptionTabsAdapter bottomOptionTabsAdapter = new BottomOptionTabsAdapter(context, new EditorActivity$initUi$bottomTabsAdapter$1(this));
        bottomOptionTabsAdapter.setItems(ArraysKt.toList((T[]) BottomOptionTab.values()));
        NEditorActivityBinding nEditorActivityBinding9 = this.binding;
        if (nEditorActivityBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nEditorActivityBinding9.tabsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.tabsRecyclerView");
        recyclerView.setLayoutManager(new GridLayoutManager(context, bottomOptionTabsAdapter.getItemCount()));
        NEditorActivityBinding nEditorActivityBinding10 = this.binding;
        if (nEditorActivityBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nEditorActivityBinding10.tabsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.tabsRecyclerView");
        recyclerView2.setAdapter(bottomOptionTabsAdapter);
    }

    private final void attachObservers() {
        registerViewModel(getGeneratorViewModel(), getDraftsViewModel(), getSavedWatermarksViewModel());
        AppCompatActivity appCompatActivity = this;
        this.mediaSelectionContractLauncher.register(appCompatActivity);
        this.filtersContractLauncher.register(appCompatActivity);
        this.addTextContractLauncher.register(appCompatActivity);
        this.contentPickerContractLauncher.register(appCompatActivity);
        this.signatureContractLauncher.register(appCompatActivity);
        this.cropContractLauncher.register(appCompatActivity);
        LifecycleOwner lifecycleOwner = this;
        getFrameTabsViewModel().onPropertyBundleApplied().observe(lifecycleOwner, new EditorActivity$attachObservers$1(this));
        getWireframesViewModel().onWireframeSelected().observe(lifecycleOwner, new EditorActivity$attachObservers$2(this));
        getTextSpacingViewModel().onTextStyleUpdated().observe(lifecycleOwner, new EditorActivity$attachObservers$3(this));
        getTextAdjustViewModel().onTextStyleUpdated().observe(lifecycleOwner, new EditorActivity$attachObservers$4(this));
        getTextTabsViewModel().onPropertyBundleApplied().observe(lifecycleOwner, new EditorActivity$attachObservers$5(this));
        getTextTabsViewModel().onTextOptionSelected().observe(lifecycleOwner, new EditorActivity$attachObservers$6(this));
        getLayoutTabsViewModel().onPropertyBundleApplied().observe(lifecycleOwner, new EditorActivity$attachObservers$7(this));
        getWatermarkViewModel().onWatermarkOptionSelected().observe(lifecycleOwner, new EditorActivity$attachObservers$8(this));
        getSavedWatermarksViewModel().onWatermarkSaved().observe(lifecycleOwner, new LiveEventObserver(new EditorActivity$attachObservers$9(this)));
        getSavedWatermarksViewModel().onWatermarkImportRequested().observe(lifecycleOwner, new LiveEventObserver(new EditorActivity$attachObservers$10(this)));
        getMediaOptionViewModel().onMediaPropertyUpdated().observe(lifecycleOwner, new EditorActivity$attachObservers$11(this));
        getMediaOptionViewModel().onMediaOptionSelected().observe(lifecycleOwner, new LiveEventObserver(new EditorActivity$attachObservers$12(this)));
        getCommonSliderViewModel().onSliderValueUpdated().observe(lifecycleOwner, new EditorActivity$attachObservers$13(this));
        getNudgeViewModel().onNudged().observe(lifecycleOwner, new EditorActivity$attachObservers$14(this));
        getGeneratorViewModel().exported().observe(lifecycleOwner, new EditorActivity$attachObservers$15(this));
        getDraftsViewModel().onDraftSaved().observe(lifecycleOwner, new EditorActivity$attachObservers$16(this));
    }

    /* access modifiers changed from: private */
    public final void initData() {
        Intent intent = getIntent();
        ArrayList arrayList = null;
        FrameSize frameSize = intent != null ? (FrameSize) intent.getParcelableExtra(ActivityExtra.FRAME_SIZE) : null;
        if (frameSize != null) {
            applyFrameSize(frameSize);
        }
        Intent intent2 = getIntent();
        Template template = intent2 != null ? (Template) intent2.getParcelableExtra(ActivityExtra.TRENDING_TEMPLATE) : null;
        if (template != null) {
            applyTemplate(template);
        }
        Intent intent3 = getIntent();
        String stringExtra = intent3 != null ? intent3.getStringExtra(ActivityExtra.WIREFRAME_ID) : null;
        if (stringExtra != null) {
            applyWireframe(stringExtra);
        }
        Intent intent4 = getIntent();
        String stringExtra2 = intent4 != null ? intent4.getStringExtra(ActivityExtra.DRAFT_ID) : null;
        if (stringExtra2 != null) {
            applyDraft(stringExtra2);
        }
        Intent intent5 = getIntent();
        if (intent5 != null) {
            arrayList = intent5.getParcelableArrayListExtra(ActivityExtra.EXTRA_CONTENTS);
        }
        Collection collection = arrayList;
        if (!(collection == null || collection.isEmpty())) {
            applyExtraMediaContents(arrayList);
        }
    }

    private final void applyFrameSize(FrameSize frameSize) {
        getFrame().getFrameEntity().applyProperty(new FrameProperty.AspectRatio(frameSize.ratio()));
    }

    private final void applyTemplate(Template template) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new EditorActivity$applyTemplate$1(this, template, (Continuation) null), 3, (Object) null);
    }

    private final void applyWireframe(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new EditorActivity$applyWireframe$1(this, str, (Continuation) null), 3, (Object) null);
    }

    private final void applyDraft(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), getDraftsViewModel().getDraftExceptionHandler(), (CoroutineStart) null, new EditorActivity$applyDraft$1(this, str, (Continuation) null), 2, (Object) null);
    }

    private final void applyExtraMediaContents(ArrayList<MediaContent> arrayList) {
        Iterator<MediaContent> it = arrayList.iterator();
        while (it.hasNext()) {
            MediaContent next = it.next();
            if (next != null) {
                NicoPropertyBundle nicoPropertyBundle = new NicoPropertyBundle(MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, (List) null, 2, (DefaultConstructorMarker) null);
                nicoPropertyBundle.addProperties(new MediaProperty.Content(next));
                getFrame().updateMediaEntity(nicoPropertyBundle);
            }
        }
        getFrame().post(new EditorActivity$applyExtraMediaContents$1(this, arrayList));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        getFrame().onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getFrame().onResume();
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this).setTitle(C4175R.string.editor_exit_confirmation_title).setMessage(C4175R.string.editor_exit_confirmation_message).setPositiveButton(C4175R.string.editor_exit_confirmation_positive_action, (DialogInterface.OnClickListener) new EditorActivity$onBackPressed$1(this)).setNegativeButton(C4175R.string.editor_exit_confirmation_negative_action, (DialogInterface.OnClickListener) new EditorActivity$onBackPressed$2(this)).setNeutralButton(C4175R.string.editor_exit_confirmation_neutral_action, (DialogInterface.OnClickListener) EditorActivity$onBackPressed$3.INSTANCE).show();
    }

    /* access modifiers changed from: private */
    public final EditorFrame getFrame() {
        NEditorActivityBinding nEditorActivityBinding = this.binding;
        if (nEditorActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditorFrame editorFrame = nEditorActivityBinding.frame;
        Intrinsics.checkNotNullExpressionValue(editorFrame, "binding.frame");
        return editorFrame;
    }

    /* access modifiers changed from: private */
    public final void onExportButtonTapped() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new EditorActivity$onExportButtonTapped$1(this, (Continuation) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void saveDraft(boolean z) {
        this.exitAfterDraftIsSaved = z;
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), getGeneratorViewModel().getFrameworkExceptionHandler(), (CoroutineStart) null, new EditorActivity$saveDraft$1(this, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createExportCommandSource(boolean r5, kotlin.coroutines.Continuation<? super editor.editor.export.command.ExportCommandSource> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof editor.editor.EditorActivity$createExportCommandSource$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            editor.editor.EditorActivity$createExportCommandSource$1 r0 = (editor.editor.EditorActivity$createExportCommandSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            editor.editor.EditorActivity$createExportCommandSource$1 r0 = new editor.editor.EditorActivity$createExportCommandSource$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            editor.editor.EditorActivity r5 = (editor.editor.EditorActivity) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0055
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            if (r5 == 0) goto L_0x0054
            androidx.fragment.app.FragmentManager r5 = r4.getSupportFragmentManager()
            java.lang.String r6 = "supportFragmentManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            editor.util.ExtKt.clearBackStack(r5)
            r5 = 500(0x1f4, double:2.47E-321)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r5, r0)
            if (r5 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r5 = r4
        L_0x0055:
            editor.editor.export.command.ExportCommandUtil r6 = editor.editor.export.command.ExportCommandUtil.INSTANCE
            com.memes.editor.databinding.NEditorActivityBinding r0 = r5.binding
            if (r0 != 0) goto L_0x0060
            java.lang.String r1 = "binding"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0060:
            editor.editor.editorframehost.frame.EditorFrame r0 = r0.frame
            java.lang.String r1 = "binding.frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.memes.commons.output.OutputTargetGenerator r5 = r5.getOutputTargetGenerator()
            editor.editor.export.command.ExportCommandSource r5 = r6.prepareCommandSource(r0, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.editor.EditorActivity.createExportCommandSource(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object createExportCommandSource$default(EditorActivity editorActivity, boolean z, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            return editorActivity.createExportCommandSource(z, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createExportCommandSource");
    }

    /* access modifiers changed from: private */
    public final void handleTextTrigger(NicoTrigger nicoTrigger) {
        Timber.m300d("handleTextTrigger: " + nicoTrigger, new Object[0]);
        String token = nicoTrigger.getToken();
        TextStyle textStyle = (TextStyle) getFrame().getTextEntity(token).getStyle();
        switch (nicoTrigger.getTarget()) {
            case 1:
                getTextAdjustViewModel().setTextStyle(token, textStyle);
                getFragmentManagerUtil().showTextAdjustFragment();
                return;
            case 2:
                getNudgeViewModel().setToken(token);
                getFragmentManagerUtil().showNudgeFragment();
                return;
            case 3:
                getTextSpacingViewModel().setTextStyle(token, textStyle);
                getTextSpacingViewModel().setTextLineCount(getFrame().getTextEntity(token).getTextLineCount());
                getFragmentManagerUtil().showTextSpacingFragment();
                return;
            case 4:
                showEditTextPage(textStyle.getText(), token, textStyle.isWatermark());
                return;
            case 5:
                getFrame().duplicateEntity(token);
                return;
            case 6:
                getFrame().deleteEntity(token);
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                ExtKt.clearBackStack(supportFragmentManager);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public final void handleMediaTrigger(NicoTrigger nicoTrigger) {
        Timber.m300d("handleMediaTrigger: " + nicoTrigger, new Object[0]);
        String token = nicoTrigger.getToken();
        MediaStyle mediaStyle = (MediaStyle) getFrame().getMediaEntity(token).getStyle();
        int target = nicoTrigger.getTarget();
        if (target != 15) {
            switch (target) {
                case 1:
                    MediaContent content = mediaStyle.getContent();
                    getFrame().updateEntity(NicoPropertyBundle.Companion.from(token, new MediaProperty.AspectResize(content != null ? content.aspectRatio() : 1.0f)));
                    return;
                case 2:
                    getFrame().duplicateEntity(token);
                    return;
                case 3:
                    showMediaSelectionPage(token, mediaStyle);
                    return;
                case 4:
                    getFrame().deleteEntity(token);
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    ExtKt.clearBackStack(supportFragmentManager);
                    return;
                case 5:
                    getNudgeViewModel().setToken(token);
                    getFragmentManagerUtil().showNudgeFragment();
                    return;
                case 6:
                    showRotationSlider(token, mediaStyle.getRotation());
                    return;
                case 7:
                    showScaleSlider(token, mediaStyle.getScale());
                    return;
                case 8:
                    showCropTool(token, mediaStyle);
                    return;
                case 9:
                    showOpacitySlider(token, mediaStyle.getOpacity());
                    return;
                default:
                    return;
            }
        } else {
            showFilters(token, mediaStyle, FilterRequest.FilterTab.FILTERS);
        }
    }

    private final void showFilters(String str, MediaStyle mediaStyle, FilterRequest.FilterTab filterTab) {
        MediaContent mediaContent;
        MediaFilter mediaFilter;
        CropSpec cropSpec = mediaStyle.getCropSpec();
        if (cropSpec == null || (mediaContent = cropSpec.getContent()) == null) {
            mediaContent = mediaStyle.getOriginalContent();
        }
        if (mediaContent != null) {
            FilterSpec filterSpec = mediaStyle.getFilterSpec();
            if (filterSpec == null || (mediaFilter = filterSpec.getFilter()) == null) {
                mediaFilter = new MediaFilter(Integer.valueOf(mediaContent.contentType()), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, (String) null, 126, (DefaultConstructorMarker) null);
            }
            this.filtersContractLauncher.launch(new FilterRequest(str, mediaContent, mediaFilter, filterTab), new EditorActivity$showFilters$1(this, str));
        }
    }

    /* access modifiers changed from: private */
    public final void onBottomOptionTabTapped(BottomOptionTab bottomOptionTab) {
        Timber.m300d("~> bottom-tab tapped: " + bottomOptionTab, new Object[0]);
        int i = WhenMappings.$EnumSwitchMapping$0[bottomOptionTab.ordinal()];
        if (i == 1) {
            ChoicesBottomSheet choicesBottomSheet = new ChoicesBottomSheet();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            choicesBottomSheet.show(supportFragmentManager, AddContentChoice.INSTANCE.create(), new EditorActivity$onBottomOptionTabTapped$1(this));
        } else if (i == 2) {
            FrameEntity frameEntity = getFrame().getFrameEntity();
            getWireframesViewModel().setStyle(frameEntity.getToken(), getFrame().getWireframe());
            getLayoutTabsViewModel().setStyle(frameEntity.getToken(), (FrameStyle) frameEntity.getStyle());
            getFragmentManagerUtil().showLayoutTabsFragment();
        } else if (i == 3) {
            showFrameTabsPage();
        } else if (i == 4) {
            showWatermarkPage();
        }
    }

    static /* synthetic */ void showEditTextPage$default(EditorActivity editorActivity, String str, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            editorActivity.showEditTextPage(str, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showEditTextPage");
    }

    /* access modifiers changed from: private */
    public final void showEditTextPage(String str, String str2, boolean z) {
        Timber.m300d("show edit-text: '" + str + "' " + str2 + " watermark=" + z, new Object[0]);
        this.addTextContractLauncher.launch(str, new EditorActivity$showEditTextPage$1(this, str2, z));
    }

    static /* synthetic */ void showMediaSelectionPage$default(EditorActivity editorActivity, String str, MediaStyle mediaStyle, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY;
            }
            if ((i & 2) != 0) {
                mediaStyle = null;
            }
            editorActivity.showMediaSelectionPage(str, mediaStyle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMediaSelectionPage");
    }

    /* access modifiers changed from: private */
    public final void showMediaSelectionPage(String str, MediaStyle mediaStyle) {
        int i;
        MediaSelectionConfig mediaSelectionConfig;
        String str2 = str;
        MediaStyle mediaStyle2 = mediaStyle;
        Timber.m300d("show media-selection: token=" + str2 + " existing-style=" + mediaStyle2, new Object[0]);
        if (mediaStyle2 == null || !mediaStyle.isWatermark()) {
            Iterable<CoreEntity> entities = getFrame().getEntities();
            if (!(entities instanceof Collection) || !((Collection) entities).isEmpty()) {
                i = 0;
                for (CoreEntity coreEntity : entities) {
                    if ((coreEntity instanceof MediaEntity) && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            } else {
                i = 0;
            }
            int i2 = 12 - i;
            boolean z = i2 <= 0;
            boolean z2 = mediaStyle2 != null;
            if (z2 || !z) {
                if (z2) {
                    mediaSelectionConfig = new MediaSelectionConfig(1, (List) null, true, 2, (DefaultConstructorMarker) null);
                } else {
                    mediaSelectionConfig = new MediaSelectionConfig(i2, (List) null, false, 6, (DefaultConstructorMarker) null);
                }
                this.mediaSelectionContractLauncher.launch(mediaSelectionConfig, new EditorActivity$showMediaSelectionPage$2(this, z2, str2));
                return;
            }
            String string = getString(C4175R.string.media_selection_limit_reached_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.media…tion_limit_reached_title)");
            String string2 = getString(C4175R.string.media_selection_limit_reached_description, new Object[]{Integer.valueOf(i), 12});
            Intrinsics.checkNotNullExpressionValue(string2, "getString(\n\t\t\t\t\tR.string…LLOWED_MEDIA_COUNT,\n\t\t\t\t)");
            AlertMessageConfig alertMessageConfig = new AlertMessageConfig(string, string2, getString(C4175R.string.f963ok), (String) null, 8, (DefaultConstructorMarker) null);
            AlertMessageBottomSheet alertMessageBottomSheet = new AlertMessageBottomSheet();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            alertMessageBottomSheet.show(supportFragmentManager, alertMessageConfig, EditorActivity$showMediaSelectionPage$1.INSTANCE);
            return;
        }
        PhotoWatermarkSource watermarkSource = mediaStyle.getWatermarkSource();
        if (watermarkSource != null) {
            int i3 = WhenMappings.$EnumSwitchMapping$1[watermarkSource.ordinal()];
            if (i3 == 1) {
                showContentPicker(ContentPickerTarget.PHOTO, str2, true);
                return;
            } else if (i3 == 2) {
                showSignatureWatermarkTool(str);
                return;
            }
        }
        throw new RuntimeException("Unknown watermark-source for style: " + mediaStyle2);
    }

    static /* synthetic */ void showContentPicker$default(EditorActivity editorActivity, ContentPickerTarget contentPickerTarget, String str, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            editorActivity.showContentPicker(contentPickerTarget, str, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showContentPicker");
    }

    private final void showContentPicker(ContentPickerTarget contentPickerTarget, String str, boolean z) {
        Timber.m300d("~> pick-content: " + contentPickerTarget + " for " + str, new Object[0]);
        if (!z || contentPickerTarget == ContentPickerTarget.PHOTO) {
            this.contentPickerContractLauncher.launch(contentPickerTarget, new EditorActivity$showContentPicker$1(this, str, z, contentPickerTarget));
            return;
        }
        throw new RuntimeException("Only Photo content can be picked as Watermark.");
    }

    static /* synthetic */ void showSignatureWatermarkTool$default(EditorActivity editorActivity, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            editorActivity.showSignatureWatermarkTool(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSignatureWatermarkTool");
    }

    private final void showSignatureWatermarkTool(String str) {
        Timber.m300d("~> pick-signature for " + str, new Object[0]);
        this.signatureContractLauncher.launch(OutputTargetGenerator.setDefaultOutputDestination$default(getOutputTargetGenerator(), (String) null, (String) null, (String) null, false, false, 31, (Object) null).getOutputFile(), new EditorActivity$showSignatureWatermarkTool$1(this, str));
    }

    private final void showCropTool(String str, MediaStyle mediaStyle) {
        boolean z = false;
        Timber.m300d("~> crop " + mediaStyle + " for " + str, new Object[0]);
        MediaContent content = mediaStyle.getContent();
        if (content != null) {
            boolean z2 = mediaStyle.getCropSpec() != null;
            if (mediaStyle.getFilterSpec() != null) {
                z = true;
            }
            if (z2 || z) {
                List<Choice> create = CropChoice.INSTANCE.create();
                ChoicesBottomSheet choicesBottomSheet = new ChoicesBottomSheet();
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                choicesBottomSheet.show(supportFragmentManager, create, new EditorActivity$showCropTool$1(this, mediaStyle, str));
                return;
            }
            showCropTool(str, new CropSpec(content, (CropBounds) null, 2, (DefaultConstructorMarker) null));
        }
    }

    /* access modifiers changed from: private */
    public final void showCropTool(String str, CropSpec cropSpec) {
        this.cropContractLauncher.launch(cropSpec, new EditorActivity$showCropTool$2(this, str));
    }

    /* access modifiers changed from: private */
    public final void showFrameTabsPage() {
        FrameEntity frameEntity = getFrame().getFrameEntity();
        getFrameTabsViewModel().setStyle(frameEntity.getToken(), (FrameStyle) frameEntity.getStyle());
        getFragmentManagerUtil().showFrameTabsFragment();
    }

    /* access modifiers changed from: private */
    public final void showWatermarkPage() {
        getWatermarkViewModel().setOfficialWatermarkVisibility(getFrame().getWatermarkEntity().isVisible());
        getFragmentManagerUtil().showWatermarkFragment();
    }

    private final void showRotationSlider(String str, float f) {
        String string = getString(C4175R.string.rotate);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.rotate)");
        showSingleSlider(str, new CommonSliderInput(6, string, f, CoreConfig.INSTANCE.getRotationRange()));
    }

    private final void showScaleSlider(String str, float f) {
        String string = getString(C4175R.string.scale);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.scale)");
        showSingleSlider(str, new CommonSliderInput(7, string, f, CoreConfig.INSTANCE.getScaleRange()));
    }

    private final void showOpacitySlider(String str, float f) {
        String string = getString(C4175R.string.opacity);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.opacity)");
        showSingleSlider(str, new CommonSliderInput(9, string, f, CoreConfig.INSTANCE.getOpacityRange()));
    }

    private final void showSingleSlider(String str, CommonSliderInput commonSliderInput) {
        Timber.m300d("~> show-slider-panel with " + commonSliderInput + " for " + str + ClassUtils.PACKAGE_SEPARATOR_CHAR, new Object[0]);
        getCommonSliderViewModel().setInput(str, commonSliderInput);
        getFragmentManagerUtil().showSingleSliderFragment();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\tj\u0002`\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, mo26107d2 = {"Leditor/editor/EditorActivity$EditorFrameCallbackWrapper;", "Leditor/editor/editorframehost/frame/EditorFrameCallback;", "(Leditor/editor/EditorActivity;)V", "onEntityTapped", "", "entity", "Leditor/editor/equipment/media/MediaEntity;", "Leditor/editor/equipment/text/TextEntity;", "onSaveEntityAsWatermarkTapped", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/util/TypedCoreEntity;", "onTextEntityDoubleTapped", "onTotalEntityVisibilityCountChanged", "visible", "", "hidden", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EditorActivity.kt */
    public final class EditorFrameCallbackWrapper implements EditorFrameCallback {
        public EditorFrameCallbackWrapper() {
        }

        public void onEntityTapped(TextEntity textEntity) {
            Intrinsics.checkNotNullParameter(textEntity, "entity");
            Timber.m300d("~> entity-tapped " + textEntity.getToken(), new Object[0]);
            TextStyle textStyle = (TextStyle) textEntity.getStyle();
            if (textEntity.isDefault()) {
                EditorActivity.this.showEditTextPage(textStyle.getText(), textEntity.getToken(), textStyle.isWatermark());
                return;
            }
            EditorActivity.this.getTextTabsViewModel().setStyle(textEntity.getToken(), textStyle);
            EditorActivity.this.getTextAdjustViewModel().setTextStyle(textEntity.getToken(), textStyle);
            EditorActivity.this.getTextSpacingViewModel().setTextStyle(textEntity.getToken(), textStyle);
            EditorActivity.this.getNudgeViewModel().setToken(textEntity.getToken());
            EditorActivity.this.getFragmentManagerUtil().showTextTabsFragment(textEntity.getToken());
        }

        public void onEntityTapped(MediaEntity mediaEntity) {
            Intrinsics.checkNotNullParameter(mediaEntity, "entity");
            Timber.m300d("~> entity-tapped " + mediaEntity.getToken(), new Object[0]);
            MediaStyle mediaStyle = (MediaStyle) mediaEntity.getStyle();
            if (mediaEntity.isDefault()) {
                EditorActivity.this.showMediaSelectionPage(mediaEntity.getToken(), (MediaStyle) mediaEntity.getStyle());
                return;
            }
            EditorActivity.this.getMediaOptionViewModel().setStyle(mediaEntity.getToken(), mediaStyle);
            EditorActivity.this.getNudgeViewModel().setToken(mediaEntity.getToken());
            EditorActivity.this.getCommonSliderViewModel().updateTokenAndInputValuesFromStyle(mediaEntity.getToken(), mediaStyle);
            EditorActivity.this.getFragmentManagerUtil().showMediaTabsFragment(mediaEntity.getToken());
        }

        public void onTextEntityDoubleTapped(TextEntity textEntity) {
            Intrinsics.checkNotNullParameter(textEntity, "entity");
            Timber.m300d("~> entity-tapped double-tap " + textEntity.getToken(), new Object[0]);
            TextStyle textStyle = (TextStyle) textEntity.getStyle();
            EditorActivity.this.showEditTextPage(textStyle.getText(), textEntity.getToken(), textStyle.isWatermark());
        }

        public void onSaveEntityAsWatermarkTapped(CoreEntity<?, ?> coreEntity) {
            Intrinsics.checkNotNullParameter(coreEntity, "entity");
            Timber.m300d("~> save-watermark " + coreEntity.getToken(), new Object[0]);
            SaveWatermarkBottomSheet saveWatermarkBottomSheet = new SaveWatermarkBottomSheet();
            FragmentManager supportFragmentManager = EditorActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            saveWatermarkBottomSheet.show(supportFragmentManager, new C4673x49bfaade(this, coreEntity));
        }

        public void onTotalEntityVisibilityCountChanged(int i, int i2) {
            Timber.m300d("~> entity-count-change " + i + " / " + (i + i2), new Object[0]);
            if (i2 > 0) {
                TextView textView = EditorActivity.access$getBinding$p(EditorActivity.this).hiddenEntitiesIndicatorView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.hiddenEntitiesIndicatorView");
                textView.setText(EditorActivity.this.getResources().getQuantityString(C4175R.plurals.n_editor_hidden_entities_warning, i2, new Object[]{Integer.valueOf(i2)}));
                TextView textView2 = EditorActivity.access$getBinding$p(EditorActivity.this).hiddenEntitiesIndicatorView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.hiddenEntitiesIndicatorView");
                textView2.setVisibility(0);
                return;
            }
            TextView textView3 = EditorActivity.access$getBinding$p(EditorActivity.this).hiddenEntitiesIndicatorView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.hiddenEntitiesIndicatorView");
            textView3.setVisibility(8);
        }
    }

    public void updateEditorPlan(EditorPlan editorPlan, EditorPlanRequirement editorPlanRequirement) {
        Intrinsics.checkNotNullParameter(editorPlan, "plan");
        super.updateEditorPlan(editorPlan, editorPlanRequirement);
        getWatermarkViewModel().setEditorPlan(editorPlan, editorPlanRequirement);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        Timber.m300d("~> save-instance " + bundle.keySet(), new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        super.onRestoreInstanceState(bundle);
        Timber.m300d("~> restore-instance " + bundle.keySet(), new Object[0]);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        ExtKt.clearBackStack(supportFragmentManager);
    }
}
