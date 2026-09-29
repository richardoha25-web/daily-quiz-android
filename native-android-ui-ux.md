# RichInsights — Native Android V2 UI/UX Blueprint

## 1. Purpose

This document defines the visual and user-experience direction for **RichInsights**, the native Android educational platform.

V2 is a new native experience. V1 is reference material only and must not constrain the new design.

## 2. Product experience

**Product:** RichInsights  
**Tagline:** **Grow. Excel.**

Core feeling: **Clean Competitive**

RichInsights should feel:
- intelligent;
- modern;
- polished;
- energetic;
- trustworthy;
- accessible;
- educational without feeling childish.

The design should support RichInsights as a broader educational platform rather than making the product feel like a quiz app with extra sections.

Avoid:
- excessive gradients;
- visual clutter;
- generic unmodified Material styling;
- overly corporate styling;
- childish game styling;
- unnecessary decoration;
- separate visual identities for individual sections.

## 3. Visual identity

RichInsights uses a **deep navy → intelligent blue → electric cyan → restrained gold** visual hierarchy.

### Brand palette

- **Deep Navy — `#102A43`**
  - primary foundation for strong hierarchy, navigation, headings, and trusted brand surfaces.
- **Intelligent Blue — `#1769E0`**
  - principal action and learning color.
- **Electric Cyan — `#19B5FE`**
  - controlled signature accent for discovery, emphasis, interactive highlights, and selected modern details.
- **Warm Gold — `#F4B942`**
  - restrained achievement accent for points, streaks, milestones, certificates, and similar positive accomplishments.

### Supporting UI palette

- **Background — `#F7F9FC`**
- **Surface — `#FFFFFF`**
- **Primary text — `#172033`**
- **Secondary text — `#667085`**
- **Success — `#22A06B`**
- **Error — `#D64545`**

Semantic green and red are reserved primarily for success, confirmation, incorrect, warning/error, and validation states. Gold is not a general-purpose status color.

The palette should remain controlled. RichInsights should not become a rainbow-style educational app, and individual product sections should not introduce competing brand palettes.

Final implementation tokens must be checked for contrast and accessibility before being treated as production-final.

## 4. Native design foundation

Use **Kotlin + Jetpack Compose** with a reusable RichInsights design system.

The design system will establish:
- typography;
- color roles;
- spacing;
- shapes;
- elevation;
- buttons;
- cards;
- inputs;
- dialogs;
- feedback states;
- loading/error/empty states;
- navigation;
- accessibility behavior;
- reusable product components.

Material 3 may provide underlying primitives, but RichInsights must have its own visual identity and token system.

## 5. Brand & Launch Identity

This section defines the product identity layer that sits around the application UI. It is deliberately established before backend integration so later implementation does not force branding decisions into technical structure.

### 5.1 Brand architecture

The product identity has three distinct layers:

1. **Brand mark / symbol**
   - the recognizable visual symbol associated with RichInsights;
   - must remain identifiable at very small sizes;
   - should communicate intelligence, growth, learning, insight, or a related product concept without becoming a literal generic education icon;
   - must work independently from the wordmark.

2. **Wordmark / product name**
   - **RichInsights**
   - used where there is enough visual space to communicate the product name clearly;
   - typography and exact treatment will be finalized with the brand asset work.

3. **Tagline**
   - **Grow. Excel.**
   - supports the product promise but is not part of the compact launcher icon;
   - should appear selectively in launch, onboarding, store/marketing, and other appropriate branded surfaces.

The three layers must feel like one identity rather than three unrelated graphics.

### 5.2 App icon direction

The Android launcher icon is a high-priority brand asset because it is one of the user's first visual encounters with RichInsights.

The icon must:
- be recognizable without the app name;
- remain legible at small launcher sizes;
- work in Android adaptive-icon contexts;
- retain a strong silhouette;
- use the established RichInsights palette;
- avoid unnecessary text;
- avoid placing **Grow. Excel.** inside the icon;
- avoid tiny details that disappear at small sizes;
- avoid looking like a generic quiz, school, book, trophy, or finance icon unless such imagery is deliberately transformed into a distinctive RichInsights symbol.

The icon should primarily use the established visual hierarchy:

**Deep Navy → Intelligent Blue → Electric Cyan → restrained Gold**

Gold should remain an accent rather than becoming the dominant icon color.

### 5.3 Icon concept development

The final icon concept is **not locked yet**.

Before production assets are created, the design process will explore a small number of deliberately different RichInsights symbol directions. Candidate directions may include abstract combinations of:
- insight/discovery;
- upward growth;
- learning/knowledge;
- a distinctive initial or monogram;
- layered or dimensional information;
- a refined symbol that can scale from launcher icon to brand mark.

The goal is not to select a familiar education symbol. The goal is to develop a distinctive RichInsights mark that can represent the broader platform as it expands into learning, quizzes, Bible, news, and future experiences.

The final concept must be approved before the production icon assets are treated as locked.

### 5.4 Adaptive icon requirements

The Android implementation will use the proper adaptive icon structure rather than a single flattened image where practical.

The final asset package should account for:
- foreground artwork;
- background treatment;
- safe visual area;
- launcher masking;
- different launcher shapes;
- small-size legibility;
- possible light/dark launcher environments.

Important visual elements must remain inside the safe area and must not depend on the exact launcher mask shape.

### 5.5 Icon asset system

Production branding will eventually provide the required Android resources, including:
- adaptive icon foreground;
- adaptive icon background;
- legacy/fallback launcher treatment where needed;
- appropriate density/resource variants;
- transparent artwork where required by the adaptive-icon structure.

The source artwork should be retained in an editable/vector-friendly form so future refinements do not require rebuilding the brand from a flattened screenshot.

### 5.6 Tagline usage

The official tagline is:

**Grow. Excel.**

It should be treated as a supporting brand statement, not a mandatory UI label.

Appropriate uses may include:
- launch/splash experience;
- onboarding;
- selected empty or welcome states;
- store listing and marketing materials;
- promotional graphics;
- selected brand-forward moments.

It should generally not appear:
- inside the launcher icon;
- repeatedly on every screen;
- inside compact navigation;
- in technical configuration;
- in places where it competes with functional content.

The tagline must remain visually secondary to the RichInsights name and core product action.

### 5.7 Launch and splash experience

The launch experience should create a polished first impression while remaining fast and restrained.

Conceptual sequence:

**RichInsights symbol → subtle brand motion → RichInsights → Grow. Excel. → application**

This is a conceptual direction, not a locked animation storyboard.

Requirements:
- use the final approved brand mark;
- avoid long splash delays;
- do not make users wait for decorative animation;
- respect Android's native splash-screen behavior;
- transition cleanly into the main RichInsights experience;
- remain performant on lower-end Android devices;
- avoid automatically starting product content or audio during launch.

The exact animation, duration, easing, and transition will be defined after the brand mark is finalized and the Android launch implementation is tested.

### 5.8 Launch implementation boundary

The launch experience is outside the primary navigation shell.

The conceptual application flow is:

**Android launch/splash → RichInsights application → primary navigation shell → Home / Learn / Quiz / Bible / News**

Therefore, adding the launch experience does not require restructuring the navigation architecture already established in V2.

The brand identity layer also remains independent from Firebase, quiz logic, content providers, and monetization.

### 5.9 Implementation timing

Brand and launch work is divided into deliberate phases:

**Phase A — documented direction**
- define brand architecture;
- define icon requirements;
- define tagline usage;
- define launch experience;
- establish asset requirements.

**Phase B — visual exploration**
- create several candidate brand-mark directions;
- compare their scalability and distinctiveness;
- select a direction;
- refine the selected mark.

**Phase C — production assets**
- create final launcher/adaptive-icon assets;
- create required brand/launch assets;
- verify small-size rendering;
- verify Android launcher behavior.

**Phase D — Android integration**
- add launcher resources;
- configure the Android application icon;
- implement the approved splash/launch experience;
- connect the launch transition to the existing navigation shell.

**Phase E — device verification**
- build;
- install;
- test launch behavior;
- test icon appearance across available launcher contexts;
- test different device/window conditions;
- fix issues;
- checkpoint.

No production icon or animation should be considered final merely because it looks good in a design canvas. It must also survive actual Android rendering and device testing.

## 6. Primary navigation

### Compact phones

**Home | Learn | Quiz | Bible | News**

### Profile & Settings

Profile and settings are secondary/global destinations, accessed through the appropriate profile or account action rather than taking a permanent primary-navigation slot.

### Larger screens

Use adaptive navigation appropriate to the available window size. Do not stretch a phone bottom bar across large screens.

Each primary destination should preserve useful navigation state where appropriate.

## 7. Home

Home is the platform entry point.

Potential hierarchy:
1. greeting/personal context;
2. daily challenge;
3. progress/streak;
4. continue learning;
5. featured categories/content;
6. relevant recommendations.

The exact layout will be established through later wireframes and requirements rather than prematurely locking the screen here.

## 8. Learn

Learn is the broader educational area.

It may contain:
- structured learning content;
- lessons;
- topics;
- explanations;
- study experiences;
- learning progress.

The first release should not attempt to build the entire future learning system. The destination exists so RichInsights can grow beyond quizzes cleanly.

## 9. Quiz

Quiz is a major platform experience, not the entire product.

Initial areas:
- General Knowledge;
- Science;
- Africa & Nigeria;
- Current Affairs;
- Bible quizzes.

The UI consumes validated V2 question objects and remains independent of content providers.

### Quiz experience

The quiz interface should clearly communicate:
- progress;
- question;
- answer choices;
- relevant timing;
- score/streak context;
- immediate feedback.

Answer states include:
- default;
- pressed/selected;
- correct;
- incorrect;
- disabled/locked.

Feedback must be immediate, clear, and accessible.

The exact timer and other detailed interaction rules should be validated before being locked into the final design.

## 10. Results and progress

Results should communicate:
- completion;
- score;
- accuracy;
- correct/wrong count;
- points;
- streak;
- progress;
- next action.

Future experiences may add explanations, topic performance, achievements, recommendations, and learning feedback.

## 11. Bible

Bible is a dedicated product area.

Conceptual structure:

    Bible
    ├── Read Bible
    │   ├── Book
    │   ├── Chapter
    │   └── Reader
    ├── Bible Quiz
    └── Future Study

Reader requirements:
- offline reading when properly licensed content is available;
- book/chapter navigation;
- search;
- silent reading by default;
- user-triggered read-aloud;
- play/pause/resume/stop;
- future speed/voice controls.

Read-aloud must never start automatically.

## 12. News

News is a dedicated top-level experience.

It remains architecturally separate from the **Current Affairs** quiz category. News should have its own content and interaction model rather than forcing news content into the quiz system.

Detailed News UX will be designed after its product requirements and content decisions are established.

## 13. Typography and interaction

Typography should provide:
- strong headings;
- highly readable learning and quiz text;
- clear scores and progress;
- comfortable body text;
- consistent hierarchy.

Use normal native Compose rendering. Do not introduce unnecessary text-selection restrictions as a copy-prevention mechanism.

Touch targets must be comfortable, and important meaning must never rely on color alone.

## 14. Responsive and adaptive design

Design for:
- phones;
- larger phones;
- landscape;
- tablets;
- foldables;
- split-screen and changing window sizes.

Do not build a phone-only layout and retrofit larger screens later.

Where useful, larger windows may display multiple related panes instead of simply enlarging a single-column phone layout.

## 15. Connectivity states

RichInsights is **online-first**, not broadly offline-first.

The UI must make connectivity requirements obvious.

### Limited local/offline support

- **Home:** selected basic/cached portions may remain available offline.
- **Profile:** selected cached information such as progress and history may remain visible offline.
- **Learn:** explicitly downloaded content may be available offline.
- **Bible:** properly licensed Bible reading should remain available offline.

### Internet-required

- Quiz;
- News;
- Current Affairs;
- fresh Learn browsing/downloads;
- fresh Home content/recommendations;
- Bible quizzes;
- server-backed Bible study features;
- synchronization and live content.

Design clear states for:
- loading;
- connecting;
- offline;
- connection lost;
- empty;
- temporary failure;
- retry;
- feature unavailable because internet is required;
- ad unavailable;
- unexpected error.

Messages should be short, human-readable, and actionable. Never expose raw provider/API errors.

## 16. Advertising UX

V2 AdMob is a fresh implementation.

Rules:
- ads never cover quiz content or controls;
- quiz functionality must remain usable when an ad fails;
- interstitials belong at appropriate transitions;
- rewarded ads are optional;
- development uses test ads;
- production identifiers/configuration remain separate;
- ad loading and failure states are handled gracefully.

Exact placements are implementation decisions and must be tested rather than copied from V1.

## 17. Premium and billing UX

Future commercial surfaces may include:
- Premium;
- Remove Ads;
- premium content/features;
- purchase and restore states;
- active entitlement state.

Requirements:
- communicate value clearly;
- show price and billing period clearly;
- distinguish subscriptions from one-time products;
- explain entitlements;
- avoid deceptive urgency or aggressive paywalls;
- preserve user context through purchase flows.

Billing is planned for later stages and is not part of the initial UI foundation.

## 18. Accessibility

Requirements:
- sufficient contrast;
- no reliance on color alone;
- meaningful content descriptions where needed;
- comfortable touch targets;
- scalable text and layouts;
- logical focus and navigation semantics;
- accessibility testing across major screens.

Accessibility is a design-system requirement, not a final cleanup task.

## 19. Motion

Motion should:
- confirm interactions;
- clarify transitions;
- communicate progress;
- reinforce meaningful feedback.

Avoid excessive motion during timed quizzes. Animations must remain performant on lower-end devices.

## 20. Reusable component foundation

The design system will eventually provide reusable components such as:
- primary and secondary buttons;
- cards;
- content/category cards;
- answer options;
- progress indicators;
- timers;
- score displays;
- streak indicators;
- dialogs;
- feedback states;
- loading/error/empty states;
- navigation components;
- ad containers;
- premium/entitlement indicators.

Components should be system-level building blocks, not one-off screen decorations.

## 21. Design process

**RESEARCH → WIREFRAME → DESIGN SYSTEM → HIGH-FIDELITY SCREENS → IMPLEMENT → BUILD → INSTALL → TEST → FIX → CHECKPOINT**

Do not design every future screen before its requirements are known.

## 22. Android application identity

- **Product:** RichInsights
- **Android application/package identity:** `com.ricven.richinsights`
- **Repository:** `ricvenlimited/richinsights-android`

## 23. Current V2 status

- RichInsights is the V2 product identity.
- Native Android is the target implementation.
- The product is being designed as a broader educational platform, not a quiz-only app.
- Primary navigation is **Home / Learn / Quiz / Bible / News**.
- Profile & Settings is secondary/global.
- The visual direction is **deep navy → intelligent blue → electric cyan → restrained gold**, supported by neutral surfaces and semantic green/red.
- Adaptive navigation and responsive layouts are required.
- Bible is a major product section.
- News is separate from Current Affairs.
- Quiz UI is provider-independent.
- AdMob and billing are fresh V2 work, not copied V1 implementations.
- High-fidelity implementation follows the native foundation and domain/content contracts.
- **Brand & Launch Identity planning is now established before Firebase integration.**
- The launcher icon, brand mark, tagline usage, and launch/splash experience are intentionally separated from the navigation architecture and backend architecture.
- The current navigation shell remains valid and does not need to be redesigned because of this identity work.
- The production icon and launch animation remain deliberately unimplemented until the visual concept is explored, selected, refined, and verified on Android devices.
